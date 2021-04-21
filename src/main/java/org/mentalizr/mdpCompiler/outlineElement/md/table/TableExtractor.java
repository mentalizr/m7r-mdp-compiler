package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class TableExtractor extends OutlineElementExtractor {

    public TableExtractor() {
        super(new TableExtractionFactory());
    }

    @Override
    protected boolean isTerminated(Line line) {
        return line.asString().isBlank();
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_IGNORE;
    }

}
