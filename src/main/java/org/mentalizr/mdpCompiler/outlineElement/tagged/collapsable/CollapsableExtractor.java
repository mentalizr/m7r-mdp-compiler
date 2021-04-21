package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;


public class CollapsableExtractor extends OutlineElementExtractor {

    public CollapsableExtractor() {
        super(new CollapsableExtractionFactory());
    }

    @Override
    protected boolean isTerminated(Line line) {

        AssertMethodPrecondition.parameterNotNull("line", line);

        String lineString = line.asString();

        return !lineString.isEmpty() && !lineString.startsWith("    ") && !lineString.startsWith("--- ");
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

}
