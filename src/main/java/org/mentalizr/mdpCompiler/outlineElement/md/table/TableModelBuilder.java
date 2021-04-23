package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.remnants.TempHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableModelBuilder extends OutlineElementModelBuilder {

    private final Pattern headerMarkPattern = Pattern.compile("^:?-+:?$");

    public TableModelBuilder() {
        super(new Table());
    }

    @Override
    public TableModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof TableExtraction))
            throw new RuntimeException(TableExtraction.class.getSimpleName() + " expected.");

        List<Line> lines = extraction.getLines();
        TableModelRow header = null;
        TableModelColMetaData tableModelColMetaData = null;
        List<TableModelRow> rows = new ArrayList<>();

        int nrProcessedLines = 0;

        for (Line line : lines) {
            String lineString = line.asString().trim();

            if (!lineString.startsWith("|")) throw new IllegalStateException("All lines of table must begin with '|'.");

            List<String> rawColDataList = this.getRawColDataList(lineString);

            try {

                if (nrProcessedLines == 0) {
                    header = addHeader(rawColDataList, header);

                } else if (nrProcessedLines == 1) {
                    tableModelColMetaData = addColumnDefinition(rawColDataList, header, rows);

                } else {
                    addRow(rawColDataList, rows, tableModelColMetaData);
                }

            } catch (TableModelException e) {
                throw new MDPSyntaxError(line, e);
            }

            nrProcessedLines++;
        }

        return new TableModel(header, rows, tableModelColMetaData);
    }


    private TableModelRow addHeader(List<String> headerData, TableModelRow header) {
        if (isHeaderDefined(header)) throw new IllegalStateException("Header of TableModelBuilder is already defined.");
        return new TableModelRow(headerData);
    }

    private TableModelColMetaData addColumnDefinition(List<String> columnDefinitionList, TableModelRow header, List<TableModelRow> rows) throws TableModelException {

        if (!isHeaderDefined(header)) throw new IllegalStateException("Header definition missing.");
        if (areTableRowsDefined(rows)) throw new IllegalStateException("Table columns are already defined.");

        if (columnDefinitionList.size() == 0) throw new TableModelException("No column definition found for table.");

        TableModelColMetaData tableModelColMetaData = new TableModelColMetaData();

        for (String columnDefinition : columnDefinitionList) {

            if (!isValidHeaderMark(columnDefinition)) throw new TableModelException("No valid column definition for table. Unrecognized token: '" + columnDefinition + "'.");

            if (isAlignLeft(columnDefinition)) {
                tableModelColMetaData.addColAlignLeft();
            } else if (isAlignCenter(columnDefinition)) {
                tableModelColMetaData.addColAlignCenter();
            } else if (isAlignRight(columnDefinition)) {
                tableModelColMetaData.addColAlignRight();
            }
        }

        if (!isHeaderEmpty(header) && (header.getNrOfRows() != tableModelColMetaData.getNrCols())) {
            throw new TableModelException("Inconsistent number of columns in header and header definition.");
        }

        return tableModelColMetaData;
    }

    private void addRow(List<String> rowDataList, List<TableModelRow> rows, TableModelColMetaData tableModelColMetaData) throws TableModelException {
        TableModelRow tableModelRow = new TableModelRow(rowDataList);

        if (tableModelRow.getNrOfRows() != tableModelColMetaData.getNrCols()) {
            throw new TableModelException("Inconsistent number of columns in row definition. Expected=" + tableModelColMetaData.getNrCols() + " Actual=" + tableModelRow.getNrOfRows());
        }

        rows.add(tableModelRow);
    }

    private boolean isHeaderDefined(TableModelRow header) {
        return (header != null);
    }

    private boolean isHeaderEmpty(TableModelRow header) {
        return (header != null && header.isRowEmpty());
    }

    private boolean areTableRowsDefined(List<TableModelRow> rows) {
        return (rows.size() > 0);
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
