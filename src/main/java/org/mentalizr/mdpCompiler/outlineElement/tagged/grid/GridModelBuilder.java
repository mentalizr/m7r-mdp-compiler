package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class GridModelBuilder implements OutlineElementModelBuilder {

    private final GridAttributes gridAttributes;
    private final List<Line> lines;

    private GridModel gridModel = null;

    public GridModelBuilder(GridAttributes gridAttributes, List<Line> lines) {
        this.gridAttributes = gridAttributes;
        this.lines = Lines.shallowCopy(lines);
    }

    public GridModel getModel() throws MDPSyntaxError {
        if (this.gridModel == null) {
            buildModel();
        }
        return this.gridModel;
    }

    public void buildModel() throws MDPSyntaxError {

        this.gridModel = new GridModel();

        this.removeTagLine();

        for (Line line : this.lines) {
            String lineString = line.asString();

            if (lineString.startsWith("    ")) {
                processIndentedContent(line);

            } else if (line.asString().startsWith("--- ")) {
                processHeaderDefinition(line);

            } else if (line.asString().equals("---")) {
                processDefaultHeaderDefinition();

            } else if (line.asString().isBlank()) {
                this.gridModel.addContentLine(new Line("", line.getLineIndex()));

            } else {
                throw new IllegalStateException("Unrecognized content found. Should have lead to termination in extraction stage. " + line.asString());
            }
        }

    }

    private void removeTagLine() {
        this.lines.remove(0);
    }

    private void processIndentedContent(Line line) throws MDPSyntaxError {

        if (!this.gridModel.hasCurCard())
            throw new MDPSyntaxError(line, "Missing header definition for accordion card.");

        String contentLine = line.asString().substring(4);

        this.gridModel.addContentLine(new Line(contentLine, line.getLineIndex()));
    }

    private void processHeaderDefinition(Line line) {
        String classValue = line.asString().substring(4);
        this.gridModel.createNextColumn(classValue);
    }

    private void processDefaultHeaderDefinition() {
        this.gridModel.createNextColumn("col-sm");
    }
}
