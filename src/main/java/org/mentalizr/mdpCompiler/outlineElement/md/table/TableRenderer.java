package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class TableRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        TableModel tableModel = (TableModel) outlineElementModel;

        int indentLevel = compilerContext.getIndentLevel();

        result.addLn(indentLevel, "<table class=\"table\">");

        if (tableModel.hasHeader()) {

            result.addLn(indentLevel,"    <thead>");
            result.addLn(indentLevel, "        <tr>");

            for (int i = 0; i < tableModel.getNrOfCols(); i++) {
                String thTag = "            <th scope=\"col\"";
                if (tableModel.getAlignment(i).equals(TableModelColMetaData.Alignment.CENTER)) {
                    thTag += " class=\"text-center\"";
                } else if (tableModel.getAlignment(i).equals(TableModelColMetaData.Alignment.RIGHT)) {
                    thTag += " class=\"text-right\"";
                }
                thTag += ">" + tableModel.getHeaderData(i) + "</th>";
                result.addLn(indentLevel, thTag);
            }

            result.addLn(indentLevel, "        </tr>");
            result.addLn(indentLevel, "    </thead>");
        }

        result.addLn(indentLevel, "    <tbody>");

        for (int rowIndex = 0; rowIndex < tableModel.getNrOfRows(); rowIndex++) {
            result.addLn(indentLevel, "        <tr>");
            for (int colIndex = 0; colIndex < tableModel.getNrOfCols(); colIndex++) {
                String tdTag = "            <td";
                if (tableModel.getAlignment(colIndex).equals(TableModelColMetaData.Alignment.CENTER)) {
                    tdTag += " class=\"text-center\"";
                } else if (tableModel.getAlignment(colIndex).equals(TableModelColMetaData.Alignment.RIGHT)) {
                    tdTag += " class=\"text-right\"";
                }
//                tdTag += ">" + tableModel.getData(colIndex, rowIndex) + "</td>";
                tdTag += ">" + getInlineProcessedTableData(tableModel, colIndex, rowIndex) + "</td>";
                result.addLn(indentLevel, tdTag);
            }
            result.addLn(indentLevel, "        </tr>");
        }

        result.addLn(indentLevel, "    </tbody>");
        result.addLn(indentLevel, "</table>");
    }

    private String getInlineProcessedTableData(TableModel tableModel, int colIndex, int rowIndex) {
        String data = tableModel.getData(colIndex, rowIndex);
        return this.inlineParserMDP.parse(data);
    }

}
