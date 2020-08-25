package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;

public class ULLinesExtractor extends OutlineElementLinesExtractor {

    public ULLinesExtractor(DocumentIterator documentIterator) {
        super(documentIterator);
    }

    @Override
    protected boolean isTerminated(Line line) {
        return !line.asString().startsWith("* ") && !line.asString().isBlank();
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }
}
