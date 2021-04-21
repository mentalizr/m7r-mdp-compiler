package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class HRExtractor extends OutlineElementExtractor {

    public HRExtractor() {
        super(new HRExtractionFactory());
    }

    @Override
    protected boolean isTerminated(Line line) {
        return true;
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

}
