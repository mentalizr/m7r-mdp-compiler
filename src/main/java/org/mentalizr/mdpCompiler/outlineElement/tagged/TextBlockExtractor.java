package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class TextBlockExtractor extends OutlineElementExtractor {

    public TextBlockExtractor(ExtractionFactory extractionFactory) {
        super(extractionFactory);
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
