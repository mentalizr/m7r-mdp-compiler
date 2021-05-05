package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

import java.util.List;

public class CommentExtractor extends OutlineElementExtractor {

    @Override
    protected boolean isTerminated(Line line) {
        return !line.asString().startsWith(Comment.PREFIX);
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new CommentExtraction(lines);
    }
}
