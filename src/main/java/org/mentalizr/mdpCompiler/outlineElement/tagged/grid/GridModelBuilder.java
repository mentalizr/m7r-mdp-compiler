package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

import java.util.List;

public class GridModelBuilder extends OutlineElementTaggedModelBuilder {

    public GridModelBuilder() {
        super(new Grid());
    }

    @Override
    public GridModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof GridExtraction))
            throw new RuntimeException(GridExtraction.class.getSimpleName() + " asserted.");

        if (extraction.isEmpty())
            throw new IllegalStateException("Insufficient number of lines.");

        GridModel gridModel = new GridModel();

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        gridModel.setMdpTag(mdpTag);

        GridLineModel gridLineModel = getLineModel(extraction);
        for (ColumnLineContent columnLineContent : gridLineModel.getColumnContentList()) {
            Document document = columnLineContent.asDocument();

            List<OutlineElementModel> childElements = MDPCompiler.getModelsForSubdocument(document);

            ColumnContent columnContent = new ColumnContent(
                    columnLineContent.getClassValue(),
                    childElements
            );
            gridModel.addColumnContent(columnContent);
        }

        return gridModel;
    }

    public GridLineModel getLineModel(Extraction extraction) throws MDPSyntaxError {

        GridLineModel gridLineModel = new GridLineModel();

        List<Line> lines = extraction.getLinesWithoutTagLine();

        for (Line line : lines) {
            String lineString = line.asString();

            if (lineString.startsWith("    ")) {
                processIndentedContent(line, gridLineModel);

            } else if (line.asString().startsWith("--- ")) {
                processHeaderDefinition(line, gridLineModel);

            } else if (line.asString().equals("---")) {
                processDefaultHeaderDefinition(gridLineModel);

            } else if (line.asString().isBlank()) {
                gridLineModel.addContentLine(new Line("", line.getLineIndex()));

            } else {
                throw new IllegalStateException("Unrecognized content found. Should have lead to termination in extraction stage. " + line.asString());
            }
        }

        return gridLineModel;
    }

    private void processIndentedContent(Line line, GridLineModel gridModel) throws MDPSyntaxError {

        if (!gridModel.hasCurCard())
            throw new MDPSyntaxError(line, "Missing header definition for accordion card.");

        String contentLine = line.asString().substring(4);

        gridModel.addContentLine(new Line(contentLine, line.getLineIndex()));
    }

    private void processHeaderDefinition(Line line, GridLineModel gridModel) {
        String classValue = line.asString().substring(4);
        gridModel.createNextColumn(classValue);
    }

    private void processDefaultHeaderDefinition(GridLineModel gridModel) {
        gridModel.createNextColumn("col-sm");
    }

}
