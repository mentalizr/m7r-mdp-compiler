package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.UUID;

public class GridRenderer extends OutlineElementRenderer {

    public GridRenderer() {
        super();
    }

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        GridModel gridModel = (GridModel) outlineElementModel;
        GridAttributes gridAttributes = gridModel.getGridAttributes();

        String id = obtainId(gridAttributes);

        String marginTop = gridAttributes.getMarginTop();
        String marginBottom = gridAttributes.getMarginBottom();
        String classValue = "row mt-" + marginTop + " mb-" + marginBottom;

        result.addLn("<div class=\"" + classValue + "\" id=\"" + id + "\">");

        for (int i = 0; i < gridModel.getColumnContentList().size(); i++) {
            createRow(gridModel, i, compilerContext, result);
        }

        result.addLn("</div>");
    }

    private String obtainId(GridAttributes gridAttributes) {
        if (gridAttributes.hasId()) return gridAttributes.getId();
        return "genId-" + UUID.randomUUID();
    }

    private void createRow(GridModel gridModel, int rowIndex, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        ColumnContent columnContent = gridModel.getColumnContentList().get(rowIndex);

        result.addLn(compilerContext.getIndentLevel() + 1, "<div class=\"" + columnContent.getClassValue() + "\">");

        MDPCompiler.compileSubdocument(
                columnContent.asDocument(),
                result,
                new CompilerContext(false, compilerContext.getIndentLevel() + 1));

        result.addLn(compilerContext.getIndentLevel() + 1,"</div>");
    }

}
