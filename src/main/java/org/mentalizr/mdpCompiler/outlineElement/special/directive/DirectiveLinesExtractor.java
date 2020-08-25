package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;

public class DirectiveLinesExtractor extends OutlineElementLinesExtractor {

    public DirectiveLinesExtractor(DocumentIterator documentIterator) {
        super(documentIterator);
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
