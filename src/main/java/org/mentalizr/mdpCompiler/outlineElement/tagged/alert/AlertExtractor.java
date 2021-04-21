package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class AlertExtractor extends OutlineElementExtractor {

    public AlertExtractor() {
        super(new AlertExtractionFactory());
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
