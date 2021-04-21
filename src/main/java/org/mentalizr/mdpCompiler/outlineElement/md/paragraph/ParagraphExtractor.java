package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class ParagraphExtractor extends OutlineElementExtractor {

    public ParagraphExtractor() {
        super(new ParagraphExtractionFactory());
    }

    @Override
    protected boolean isTerminated(Line line) {
        return line.asString().isBlank();
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_IGNORE;
    }

}
