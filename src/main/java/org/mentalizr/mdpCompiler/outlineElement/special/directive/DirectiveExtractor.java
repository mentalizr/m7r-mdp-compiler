package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class DirectiveExtractor extends OutlineElementExtractor {

    public DirectiveExtractor() {
        super(new DirectiveExtractionFactory());
    }

    @Override
    protected boolean isTerminated(Line line) {
        return !line.asString().startsWith(Directive.PREFIX);
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

}
