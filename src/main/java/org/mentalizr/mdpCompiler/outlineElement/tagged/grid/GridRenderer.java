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

    public GridRenderer(Result result, GridAttributes gridAttributes, GridModel gridModel) {
        super(result);
        this.gridAttributes = gridAttributes;
        this.gridModel = gridModel;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        String id = obtainId();

        String marginTop = this.gridAttributes.getMarginTop();
        String marginBottom = this.gridAttributes.getMarginBottom();
        String classValue = "row mt-" + marginTop + " mb-" + marginBottom;

        this.result.addLn("<div class=\"" + classValue + "\" id=\"" + id + "\">");

        for (int i = 0; i<this.gridModel.getColumnContentList().size(); i++) {

            createRow(i, compilerContext);

        }

        this.result.addLn("</div>");

    }

    private String obtainId() {
        if (this.gridAttributes.hasId()) return this.gridAttributes.getId();
        return "genId-" + UUID.randomUUID().toString();
    }

    private void createRow(int rowIndex, CompilerContext compilerContext) throws MDPSyntaxError {

        ColumnContent columnContent = this.gridModel.getColumnContentList().get(rowIndex);

        this.result.addLn(compilerContext.getIndentLevel() + 1, "<div class=\"" + columnContent.getClassValue() + "\">");

        MDPCompiler.compileSubdocument(
                columnContent.asDocument(),
                this.result,
                new CompilerContext(false, compilerContext.getIndentLevel() + 1));

        this.result.addLn(compilerContext.getIndentLevel() + 1,"</div>");
    }

}
