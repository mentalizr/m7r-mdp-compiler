package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class TableRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        TableModel tableModel = (TableModel) outlineElementModel;

        int indentLevel = compilerContext.getIndentLevel();

        htmlBuilder.addLn(indentLevel, "<table class=\"table\">");

        if (tableModel.hasHeader()) {

            htmlBuilder.addLn(indentLevel,"    <thead>");
            htmlBuilder.addLn(indentLevel, "        <tr>");

            for (int i = 0; i < tableModel.getNrOfCols(); i++) {
                String thTag = "            <th scope=\"col\"";
                if (tableModel.getAlignment(i).equals(TableModelColMetaData.Alignment.CENTER)) {
                    thTag += " class=\"text-center\"";
                } else if (tableModel.getAlignment(i).equals(TableModelColMetaData.Alignment.RIGHT)) {
                    thTag += " class=\"text-right\"";
                }
                thTag += ">" + tableModel.getHeaderData(i) + "</th>";
                htmlBuilder.addLn(indentLevel, thTag);
            }

            htmlBuilder.addLn(indentLevel, "        </tr>");
            htmlBuilder.addLn(indentLevel, "    </thead>");
        }

        htmlBuilder.addLn(indentLevel, "    <tbody>");

        for (int rowIndex = 0; rowIndex < tableModel.getNrOfRows(); rowIndex++) {
            htmlBuilder.addLn(indentLevel, "        <tr>");
            for (int colIndex = 0; colIndex < tableModel.getNrOfCols(); colIndex++) {
                String tdTag = "            <td";
                if (tableModel.getAlignment(colIndex).equals(TableModelColMetaData.Alignment.CENTER)) {
                    tdTag += " class=\"text-center\"";
                } else if (tableModel.getAlignment(colIndex).equals(TableModelColMetaData.Alignment.RIGHT)) {
                    tdTag += " class=\"text-right\"";
                }
//                tdTag += ">" + tableModel.getData(colIndex, rowIndex) + "</td>";
                tdTag += ">" + getInlineProcessedTableData(tableModel, colIndex, rowIndex) + "</td>";
                htmlBuilder.addLn(indentLevel, tdTag);
            }
            htmlBuilder.addLn(indentLevel, "        </tr>");
        }

        htmlBuilder.addLn(indentLevel, "    </tbody>");
        htmlBuilder.addLn(indentLevel, "</table>");
    }

    private String getInlineProcessedTableData(TableModel tableModel, int colIndex, int rowIndex) {
        String data = tableModel.getData(colIndex, rowIndex);
        return this.inlineParserMDP.parse(data);
    }

}
