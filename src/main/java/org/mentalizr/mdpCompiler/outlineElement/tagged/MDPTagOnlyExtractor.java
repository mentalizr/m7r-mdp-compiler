package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public abstract class MDPTagOnlyExtractor extends OutlineElementExtractor {

//    public MDPTagOnlyExtractor(ExtractionFactory extractionFactory) {
//        super(extractionFactory);
//    }

    @Override
    protected boolean isTerminated(Line line) {
        return true;
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_IGNORE;
    }

}
