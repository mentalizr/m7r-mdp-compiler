package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public abstract class TextBlockExtractor extends OutlineElementExtractor {

    @Override
    protected boolean isTerminated(Line line) {
        return !line.asString().isEmpty() && !line.asString().startsWith("    ");
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

}
