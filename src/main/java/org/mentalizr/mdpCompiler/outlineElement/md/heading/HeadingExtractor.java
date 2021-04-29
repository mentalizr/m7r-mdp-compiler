package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

import java.util.List;

public class HeadingExtractor extends OutlineElementExtractor {

    @Override
    protected boolean isTerminated(Line line) {
        return true;
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new HeadingExtraction(lines);
    }

}
