package org.mentalizr.mdpCompiler.outlineElement.md.table;

import java.util.ArrayList;
import java.util.List;

public class TableModelRow {

    private final List<String> rowData;

    public TableModelRow() {
        this.rowData = new ArrayList<>();
    }

    public TableModelRow(List<String> rowData) {
        this.rowData = rowData;
    }

    public boolean isRowEmpty() {
        return this.rowData.isEmpty();
    }

    public int getNrOfRows() {
        return this.rowData.size();
    }

    public String getColData(int colIndex) {
        return this.rowData.get(colIndex);
    }

}
