package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;

import java.util.List;

public class CollapsableModelBuilder extends OutlineElementTaggedModelBuilder {

    public CollapsableModelBuilder(OutlineElementTagged outlineElementTagged) {
        super(outlineElementTagged);
    }

    @Override
    public CollapsableModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof CollapsableExtraction))
            throw new RuntimeException(CollapsableExtraction.class.getSimpleName() + " expected.");

        if (extraction.isEmpty())
            throw new IllegalStateException("Insufficient number of lines.");

        CollapsableModel collapsableModel = new CollapsableModel(this.outlineElement);
        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        collapsableModel.setMdpTag(mdpTag);

        int tagLineIndex = extraction.getTagLineIndex();
        List<Line> lines = extraction.getLinesWithoutTagLine();

        for (Line line : lines) {
            String lineString = line.asString();

            if (lineString.startsWith("    ")) {
                processIndentedContent(line, collapsableModel);

            } else if (line.asString().startsWith("--- ")) {
                processHeaderDefinition(line, collapsableModel);

            } else if (line.asString().isBlank()) {
                if (line.getLineIndex() == tagLineIndex + 1) {
                    throw new MDPSyntaxError(line, "Malformed accordion content definition. First line of content must not be blank.");
                }
                collapsableModel.addContentLine(line);

            } else {
                throw new IllegalStateException("Unrecognized content found. Should have led to termination in extraction stage. " + line.asString());
            }
        }

        return collapsableModel;
    }

    private void processIndentedContent(Line line, CollapsableModel collapsableModel) throws MDPSyntaxError {

        if (!collapsableModel.hasCurCard())
            throw new MDPSyntaxError(line, "Missing header definition for collapsable content element.");

//        String contentLine = line.asString().substring(4).trim();
        String contentLine = line.asString().substring(4);

        collapsableModel.addContentLine(new Line(contentLine, line.getLineIndex()));

    }

    private void processHeaderDefinition(Line line, CollapsableModel collapsableModel) {
        String header = line.asString().substring(4);
        collapsableModel.createNextCard(header);
    }
}
