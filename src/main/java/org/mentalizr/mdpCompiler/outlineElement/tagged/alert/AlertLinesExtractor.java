package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;

public class AlertLinesExtractor extends OutlineElementLinesExtractor {

    public AlertLinesExtractor(DocumentIterator documentIterator) {
        super(documentIterator);
    }

    @Override
    protected boolean isTerminated(Line line) {
        return this.extractedOutlineElementBuffer.getNrOfLines() == 1;
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.INCLUDE;
    }

}
