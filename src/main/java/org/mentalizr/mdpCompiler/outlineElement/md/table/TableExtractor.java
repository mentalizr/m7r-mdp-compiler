package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

import java.util.List;

public class TableExtractor extends OutlineElementExtractor {

    @Override
    protected boolean isTerminated(Line line) {
        return line.asString().isBlank();
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_IGNORE;
    }

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new TableExtraction(lines);
    }

}
