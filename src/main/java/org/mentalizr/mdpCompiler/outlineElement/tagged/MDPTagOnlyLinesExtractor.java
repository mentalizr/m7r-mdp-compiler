package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;

public class MDPTagOnlyLinesExtractor extends OutlineElementLinesExtractor {

    public MDPTagOnlyLinesExtractor(DocumentIterator documentIterator) {
        super(documentIterator);
    }

    @Override
    protected boolean isTerminated(Line line) {
        return true;
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_IGNORE;
    }

}
