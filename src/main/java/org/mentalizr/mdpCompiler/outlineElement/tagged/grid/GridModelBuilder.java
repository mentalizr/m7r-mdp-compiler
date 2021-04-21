package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class GridModelBuilder implements OutlineElementModelBuilder {

    private final GridAttributes gridAttributes;
//    private final List<Line> lines;

//    private GridModel gridModel = null;

    public GridModelBuilder(GridAttributes gridAttributes) {
        this.gridAttributes = gridAttributes;
//        this.lines = Lines.shallowCopy(lines);
    }

    @Override
    public GridModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof GridExtraction))
            throw new RuntimeException(GridExtraction.class.getSimpleName() + " asserted.");

        if (extraction.isEmpty())
            throw new IllegalStateException("Insufficient number of lines.");

        GridModel gridModel = new GridModel();
        List<Line> lines = extraction.getLinesWithoutTagLine();

        for (Line line : lines) {
            String lineString = line.asString();

            if (lineString.startsWith("    ")) {
                processIndentedContent(line, gridModel);

            } else if (line.asString().startsWith("--- ")) {
                processHeaderDefinition(line, gridModel);

            } else if (line.asString().equals("---")) {
                processDefaultHeaderDefinition(gridModel);

            } else if (line.asString().isBlank()) {
                gridModel.addContentLine(new Line("", line.getLineIndex()));

            } else {
                throw new IllegalStateException("Unrecognized content found. Should have lead to termination in extraction stage. " + line.asString());
            }
        }

        return gridModel;
    }

//    private void removeTagLine() {
//        this.lines.remove(0);
//    }

    private void processIndentedContent(Line line, GridModel gridModel) throws MDPSyntaxError {

        if (!gridModel.hasCurCard())
            throw new MDPSyntaxError(line, "Missing header definition for accordion card.");

        String contentLine = line.asString().substring(4);

        gridModel.addContentLine(new Line(contentLine, line.getLineIndex()));
    }

    private void processHeaderDefinition(Line line, GridModel gridModel) {
        String classValue = line.asString().substring(4);
        gridModel.createNextColumn(classValue);
    }

    private void processDefaultHeaderDefinition(GridModel gridModel) {
        gridModel.createNextColumn("col-sm");
    }

}
