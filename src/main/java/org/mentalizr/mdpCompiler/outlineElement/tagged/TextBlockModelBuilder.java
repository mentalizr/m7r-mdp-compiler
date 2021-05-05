package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;

import java.util.ArrayList;
import java.util.List;

public class TextBlockModelBuilder extends OutlineElementTaggedModelBuilder {

    public TextBlockModelBuilder(OutlineElementTagged outlineElementTagged) {
        super(outlineElementTagged);
    }

    @Override
    public OutlineElementModel getModel(Extraction extraction) throws MDPSyntaxError {

        // TODO Durch MDPSyntaxError ersetzen, dazu ist die MDP-Line notwendig --> Refactoring
        if (extraction.isEmpty())
            throw new IllegalStateException("Insufficient number of lines.");

        TextBlockModel textBlockModel = new TextBlockModel(this.outlineElement);

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        textBlockModel.setMdpTag(mdpTag);

        List<Line> textBlockLines = new ArrayList<>();

        List<Line> lines = extraction.getLinesWithoutTagLine();

        for (Line line : lines) {
            String lineString = line.asString();

            if (lineString.startsWith("    ")) {
                String contentLine = lineString.substring(4);
                textBlockLines.add(new Line(contentLine, line.getLineIndex()));
            } else if (lineString.isBlank()) {
                textBlockLines.add(new Line("", line.getLineIndex()));
            } else {
                throw new IllegalStateException("Unrecognized content found. Should have led to termination in extraction stage. " + line.asString());
            }
        }

        textBlockModel.setTextBlockLines(textBlockLines);

        return textBlockModel;
    }

}
