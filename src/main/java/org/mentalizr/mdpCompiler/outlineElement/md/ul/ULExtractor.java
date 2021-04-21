package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class ULExtractor extends OutlineElementExtractor {

    public ULExtractor() {
        super(new ULExtractionFactory());
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
