package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class Table extends OutlineElement {

    public static final String PREFIX = "| ";

    public Table() {
        super("| ");
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new TableExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new TableModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        TableModel tableModel = (TableModel) this.outlineElementModel;
        return new TableRenderer(tableModel);
    }

}
