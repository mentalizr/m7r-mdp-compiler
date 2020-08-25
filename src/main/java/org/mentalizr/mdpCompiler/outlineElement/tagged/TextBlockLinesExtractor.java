package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;

public class TextBlockLinesExtractor extends OutlineElementLinesExtractor {

    public TextBlockLinesExtractor(DocumentIterator documentIterator) {
        super(documentIterator);
    }

    @Override
    protected boolean isTerminated(Line line) {
        return !line.asString().isEmpty() && !line.asString().startsWith("    ");
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

}
