package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class HeadingExtractor extends OutlineElementExtractor {

    public HeadingExtractor() {
        super(new HeadingExtractionFactory());
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
