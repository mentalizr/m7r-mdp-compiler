package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

import java.util.List;

public class AlertExtractor extends OutlineElementExtractor {

    @Override
    protected boolean isTerminated(Line line) {
        return this.extractedOutlineElementBuffer.getNrOfLines() == 1;
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.INCLUDE;
    }

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new AlertExtraction(lines);
    }

}
