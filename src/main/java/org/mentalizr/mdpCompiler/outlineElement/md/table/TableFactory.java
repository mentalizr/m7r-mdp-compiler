package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class TableFactory extends OutlineElementFactory {

    public TableFactory() {
        super(Table.PREFIX);
    }

    @Override
    public OutlineElement getInstance(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        return new Table(documentIterator, result);
    }

    @Override
    public boolean isResponsible(Line line) {
        return startsWith(line) || (startsWith(line) && endsWith(line));
    }

    private boolean startsWith(Line line) {
        return line.asString().startsWith(Table.PREFIX);
    }

    private boolean endsWith(Line line) {
        return line.asString().trim().endsWith(Table.PREFIX.trim());
    }
}
