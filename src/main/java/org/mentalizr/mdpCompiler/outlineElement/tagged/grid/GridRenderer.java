package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.UUID;

public class GridRenderer extends OutlineElementRenderer {

    private final GridAttributes gridAttributes;
    private final GridModel gridModel;

    public GridRenderer(GridAttributes gridAttributes, GridModel gridModel) {
        super();
        this.gridAttributes = gridAttributes;
        this.gridModel = gridModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        String id = obtainId();

        String marginTop = this.gridAttributes.getMarginTop();
        String marginBottom = this.gridAttributes.getMarginBottom();
        String classValue = "row mt-" + marginTop + " mb-" + marginBottom;

        result.addLn("<div class=\"" + classValue + "\" id=\"" + id + "\">");

        for (int i = 0; i<this.gridModel.getColumnContentList().size(); i++) {

            createRow(i, compilerContext, result);

        }

        result.addLn("</div>");

    }

    private String obtainId() {
        if (this.gridAttributes.hasId()) return this.gridAttributes.getId();
        return "genId-" + UUID.randomUUID().toString();
    }

    private void createRow(int rowIndex, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        ColumnContent columnContent = this.gridModel.getColumnContentList().get(rowIndex);

        result.addLn(compilerContext.getIndentLevel() + 1, "<div class=\"" + columnContent.getClassValue() + "\">");

        MDPCompiler.compileSubdocument(
                columnContent.asDocument(),
                result,
                new CompilerContext(false, compilerContext.getIndentLevel() + 1));

        result.addLn(compilerContext.getIndentLevel() + 1,"</div>");
    }

}
