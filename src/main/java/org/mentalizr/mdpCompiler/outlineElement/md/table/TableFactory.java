package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class TableFactory extends OutlineElementFactory {

    public TableFactory() {
        super(Table.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new Table();
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
