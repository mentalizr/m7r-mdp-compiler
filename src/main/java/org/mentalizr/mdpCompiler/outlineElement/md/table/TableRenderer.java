package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class TableRenderer extends OutlineElementRenderer {

    private final TableModel tableModel;

    public TableRenderer(Result result, TableModel tableModel) {
        super(result);
        this.tableModel = tableModel;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        int indentLevel = compilerContext.getIndentLevel();

        this.result.addLn(indentLevel, "<table class=\"table\">");

        if (tableModel.hasHeader()) {

            this.result.addLn(indentLevel,"    <thead>");
            this.result.addLn(indentLevel, "        <tr>");

            for (int i = 0; i < tableModel.getNrOfCols(); i++) {
                String thTag = "            <th scope=\"col\"";
                if (tableModel.getAlignment(i).equals(TableModelColMetaData.Alignment.CENTER)) {
                    thTag += " class=\"text-center\"";
                } else if (tableModel.getAlignment(i).equals(TableModelColMetaData.Alignment.RIGHT)) {
                    thTag += " class=\"text-right\"";
                }
                thTag += ">" + tableModel.getHeaderData(i) + "</th>";
                this.result.addLn(indentLevel, thTag);
            }

            this.result.addLn(indentLevel, "        </tr>");
            this.result.addLn(indentLevel, "    </thead>");
        }

        this.result.addLn(indentLevel, "    <tbody>");

        for (int rowIndex = 0; rowIndex < tableModel.getNrOfRows(); rowIndex++) {
            this.result.addLn(indentLevel, "        <tr>");
            for (int colIndex = 0; colIndex < tableModel.getNrOfCols(); colIndex++) {
                String tdTag = "            <td";
                if (tableModel.getAlignment(colIndex).equals(TableModelColMetaData.Alignment.CENTER)) {
                    tdTag += " class=\"text-center\"";
                } else if (tableModel.getAlignment(colIndex).equals(TableModelColMetaData.Alignment.RIGHT)) {
                    tdTag += " class=\"text-right\"";
                }
//                tdTag += ">" + tableModel.getData(colIndex, rowIndex) + "</td>";
                tdTag += ">" + getInlineProcessedTableData(colIndex, rowIndex) + "</td>";
                this.result.addLn(indentLevel, tdTag);
            }
            this.result.addLn(indentLevel, "        </tr>");
        }

        this.result.addLn(indentLevel, "    </tbody>");
        this.result.addLn(indentLevel, "</table>");
    }

    private String getInlineProcessedTableData(int colIndex, int rowIndex) {
        String data = this.tableModel.getData(colIndex, rowIndex);
        return this.inlineParserMDP.parse(data);
    }

}
