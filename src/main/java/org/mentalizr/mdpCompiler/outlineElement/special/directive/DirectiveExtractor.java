package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

import java.util.List;

public class DirectiveExtractor extends OutlineElementExtractor {

    @Override
    protected boolean isTerminated(Line line) {
        return !line.asString().startsWith(Directive.PREFIX);
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new DirectiveExtraction(lines);
    }

}
