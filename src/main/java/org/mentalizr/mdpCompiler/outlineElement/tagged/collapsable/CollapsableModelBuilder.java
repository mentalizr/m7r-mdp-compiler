package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class CollapsableModelBuilder implements OutlineElementModelBuilder {

    private final CollapsableAttributes collapsableAttributes;
    private final List<Line> lines;

    private CollapsableModel collapsableModel = null;

    public CollapsableModelBuilder(CollapsableAttributes collapsableAttributes, List<Line> lines) {
        this.collapsableAttributes = collapsableAttributes;
        this.lines = Lines.shallowCopy(lines);
    }

    public CollapsableModel getModel() throws MDPSyntaxError {
        if (this.collapsableModel == null) {
            buildModel();
        }
        return this.collapsableModel;
    }

    public void buildModel() throws MDPSyntaxError {

        this.collapsableModel = new CollapsableModel();

        int tagLineIndex = this.removeTagLine();

        for (Line line : this.lines) {
            String lineString = line.asString();

            if (lineString.startsWith("    ")) {
                processIndentedContent(line);

            } else if (line.asString().startsWith("--- ")) {
                processHeaderDefinition(line);

            } else if (line.asString().isBlank()) {
                if (line.getLineIndex() == tagLineIndex + 1) {
                    throw new MDPSyntaxError(line, "Malformed accordion content definition. First line of content must not be blank.");
                }
                this.collapsableModel.addContentLine(line);

            } else {
                throw new IllegalStateException("Unrecognized content found. Should have lead to termination in extraction stage. " + line.asString());
            }
        }

    }

    private int removeTagLine() {
        int tagLineIndex = this.lines.get(0).getLineIndex();
        this.lines.remove(0);
        return tagLineIndex;
    }

    private void processIndentedContent(Line line) throws MDPSyntaxError {

        if (!this.collapsableModel.hasCurCard())
            throw new MDPSyntaxError(line, "Missing header definition for collapsable content element.");

//        String contentLine = line.asString().substring(4).trim();
        String contentLine = line.asString().substring(4);

        this.collapsableModel.addContentLine(new Line(contentLine, line.getLineIndex()));

    }

    private void processHeaderDefinition(Line line) {
        String header = line.asString().substring(4);
        this.collapsableModel.createNextCard(header);
    }
}
