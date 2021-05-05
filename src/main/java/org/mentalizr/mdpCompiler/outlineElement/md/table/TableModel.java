package org.mentalizr.mdpCompiler.outlineElement.md.table;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.List;

public class TableModel extends OutlineElementModel {

    private final TableModelRow header;
    private final List<TableModelRow> rows;
    private final TableModelColMetaData tableModelColMetaData;

    public TableModel(TableModelRow header, List<TableModelRow> rows, TableModelColMetaData tableModelColMetaData) {
        super(new Table());

        AssertMethodPrecondition.parameterNotNull("header", header);
        AssertMethodPrecondition.parameterNotNull("rows", rows);
        AssertMethodPrecondition.parameterNotNull("tableModelColMetaData", tableModelColMetaData);

        this.header = header;
        this.rows = rows;
        this.tableModelColMetaData = tableModelColMetaData;
    }

    public int getNrOfCols() {
        return this.tableModelColMetaData.getNrCols();
    }

    public int getNrOfRows() {
        return this.rows.size();
    }

    public boolean hasHeader() {
        return (!this.header.isRowEmpty());
    }

    public String getHeaderData(int colIndex) {

        if (!hasHeader()) throw new IllegalStateException("Table has no header.");

        if (colIndex >= this.header.getNrOfRows())
            throw new IllegalArgumentException("Header column index '" + colIndex + "' out of bounds. Tabel has " + this.header.getNrOfRows() + " columns.");

        return this.header.getColData(colIndex);
    }

    public String getData(int colIndex, int rowIndex) {

        if (colIndex >= this.tableModelColMetaData.getNrCols())
            throw new IllegalArgumentException("Column index out of bounds.");

        if (rowIndex >= this.rows.size())
            throw new IllegalArgumentException("Row index out of bounds.");

        TableModelRow tableModelRow = this.rows.get(rowIndex);
        return tableModelRow.getColData(colIndex);
    }

    public TableModelColMetaData.Alignment getAlignment(int colIndex) {

        if (colIndex >= this.tableModelColMetaData.getNrCols())
            throw new IllegalArgumentException("Column index out of bounds.");

        return this.tableModelColMetaData.getAlignment(colIndex);
    }


}
