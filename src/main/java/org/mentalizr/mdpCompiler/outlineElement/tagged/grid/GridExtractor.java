package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

import java.util.List;


public class GridExtractor extends OutlineElementExtractor {

    @Override
    protected boolean isTerminated(Line line) {

        AssertMethodPrecondition.parameterNotNull("line", line);

        String lineString = line.asString();

        return !lineString.isEmpty() && !lineString.startsWith("    ") && !lineString.startsWith("--- ") && !lineString.equals("---");
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new GridExtraction(lines);
    }

}
