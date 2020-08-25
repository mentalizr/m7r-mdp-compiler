package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.ArrayList;
import java.util.List;

public class TextBlockModelBuilder implements OutlineElementModelBuilder {

    private final List<Line> lines;

    private final Line mdpTagLine;
    private TextBlockModel textBlockModel;

    public TextBlockModelBuilder(List<Line> lines) {

        // TODO Durch MDPSyntaxError ersetzen, dazu ist die MDP-Line notwendig --> Refactoring
        if (lines.size() == 0) throw new IllegalStateException(TextBlockModelBuilder.class.getSimpleName() + ": No lines.");

        this.lines = Lines.shallowCopy(lines);

        this.mdpTagLine = lines.get(0);
        this.textBlockModel = null;
    }

    @Override
    public OutlineElementModel getModel() {

        if (this.textBlockModel == null) {
            buildModel();
        }
        return this.textBlockModel;
    }

    private void buildModel() {

        List<Line> textBlockLines = new ArrayList<>();

        removeTagLine();

        for (Line line : this.lines) {
            String lineString = line.asString();

            if (lineString.startsWith("    ")) {
                String contentLine = lineString.substring(4);
                textBlockLines.add(new Line(contentLine, line.getLineIndex()));
            } else if (lineString.isBlank()) {
                textBlockLines.add(new Line("", line.getLineIndex()));
            } else {
                throw new IllegalStateException("Unrecognized content found. Should have lead to termination in extraction stage. " + line.asString());
            }
        }

        this.textBlockModel = new TextBlockModel(textBlockLines);
    }

    private void removeTagLine() {
        this.lines.remove(0);
    }

}
