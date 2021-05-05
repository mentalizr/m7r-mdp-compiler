package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.document.Line;
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
    public boolean isResponsible(Line line) {
        return line.asString().startsWith(this.prefix) && line.asString().trim().endsWith(this.prefix.trim());
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
        return new TableRenderer();
    }

}
