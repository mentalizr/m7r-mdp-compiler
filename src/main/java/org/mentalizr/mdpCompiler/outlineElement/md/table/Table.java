package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.result.Result;

public class Table extends OutlineElement {

    public static final String PREFIX = "| ";

    public Table(DocumentIterator documentIterator, Result result) {
        super("| ", documentIterator, result);
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new TableLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new TableModelBuilder(this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        TableModel tableModel = (TableModel) this.outlineElementModel;
        return new TableRenderer(this.result, tableModel);
    }

}
