package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.remnants.TempHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableModelBuilder implements OutlineElementModelBuilder {

    private final List<Line> lines;

    private TableModelRow header;
    private final List<TableModelRow> rows;
    private TableModelColMetaData tableModelColMetaData;

    private final Pattern headerMarkPattern;

    private TableModel tableModel;

    public TableModelBuilder(List<Line> lines) {
        this.lines = lines;

        this.header = null;
        this.rows = new ArrayList<>();
        this.tableModelColMetaData = null;
        this.headerMarkPattern = Pattern.compile("^:?-+:?$");

        this.tableModel = null;
    }

    @Override
    public TableModel getModel() throws MDPSyntaxError {
        if (this.tableModel == null) {
            buildModel();
        }
        return this.tableModel;
    }

    private void buildModel() throws MDPSyntaxError {

        int nrProcessedLines = 0;

        for (Line line : this.lines) {
            String lineString = line.asString().trim();

            if (!lineString.startsWith("|")) throw new IllegalStateException("All lines of table must begin with '|'.");

            List<String> rawColDataList = this.getRawColDataList(lineString);

            try {

                if (nrProcessedLines == 0) {
                    addHeader(rawColDataList);

                } else if (nrProcessedLines == 1) {
                    addColumnDefinition(rawColDataList);

                } else {
                    addRow(rawColDataList);
                }

            } catch (TableModelException e) {
                throw new MDPSyntaxError(line, e);
            }

            nrProcessedLines++;
        }

        this.tableModel = new TableModel(this.header, this.rows, this.tableModelColMetaData);
    }


    public void addHeader(List<String> headerData) {
        if (isHeaderDefined()) throw new IllegalStateException("Header of TableModelBuilder is already defined.");
        this.header = new TableModelRow(headerData);
    }

    public void addColumnDefinition(List<String> columnDefinitionList) throws TableModelException {

        if (!isHeaderDefined()) throw new IllegalStateException("Header definition missing.");
        if (areTableRowsDefined()) throw new IllegalStateException("Table columns are already defined.");

        if (columnDefinitionList.size() == 0) throw new TableModelException("No column definition found for table.");

        this.tableModelColMetaData = new TableModelColMetaData();

        for (String columnDefinition : columnDefinitionList) {

            if (!isValidHeaderMark(columnDefinition)) throw new TableModelException("No valid column definition for table. Unrecognized token: '" + columnDefinition + "'.");

            if (isAlignLeft(columnDefinition)) {
                this.tableModelColMetaData.addColAlignLeft();
            } else if (isAlignCenter(columnDefinition)) {
                this.tableModelColMetaData.addColAlignCenter();
            } else if (isAlignRight(columnDefinition)) {
                this.tableModelColMetaData.addColAlignRight();
            }
        }

        if (!isHeaderEmpty() && (this.header.getNrOfRows() != this.tableModelColMetaData.getNrCols())) {
            throw new TableModelException("Inconsistent number of columns in header and header definition.");
        }
    }

    public void addRow(List<String> rowDataList) throws TableModelException {
        TableModelRow tableModelRow = new TableModelRow(rowDataList);

        if (tableModelRow.getNrOfRows() != this.tableModelColMetaData.getNrCols()) {
            throw new TableModelException("Inconsistent number of columns in row definition. Expected=" + this.tableModelColMetaData.getNrCols() + " Actual=" + tableModelRow.getNrOfRows());
        }

        this.rows.add(tableModelRow);
    }

    private boolean isHeaderDefined() {
        return (this.header != null);
    }

    private boolean isHeaderEmpty() {
        return (this.header != null && this.header.isRowEmpty());
    }

    private boolean areTableRowsDefined() {
        return (this.rows.size() > 0);
    }

    private boolean isValidHeaderMark(String headerMark) {
        Matcher matcher = this.headerMarkPattern.matcher(headerMark);
        return matcher.matches();
    }

    private boolean isAlignRight(String headerMark) {
        return headerMark.startsWith("-") && headerMark.endsWith(":");
    }

    private boolean isAlignLeft(String headerMark) {
        return (headerMark.startsWith(":") || headerMark.startsWith("-")) && headerMark.endsWith("-");
    }

    private boolean isAlignCenter(String headerMark) {
        return headerMark.startsWith(":") && headerMark.endsWith(":");
    }

    private List<String> getRawColDataList(String line) {
        List<String> rawColDataList = TempHelper.splitAtDelimiters(line, "|");
        rawColDataList = preProcessColDataList(rawColDataList);
        return rawColDataList;
    }

    private List<String> preProcessColDataList(List<String> rawColDataList) {
        List<String> rawColDataListTrimmed = new ArrayList<>();
        for (String col : rawColDataList) {
            rawColDataListTrimmed.add(col.trim());
        }
        return rawColDataListTrimmed;
    }

}
