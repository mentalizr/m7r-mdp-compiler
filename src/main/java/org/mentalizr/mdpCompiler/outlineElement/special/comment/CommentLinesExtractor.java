package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;

public class CommentLinesExtractor extends OutlineElementLinesExtractor {

    public CommentLinesExtractor() {
        super();
    }

    @Override
    protected boolean isTerminated(Line line) {
        return !line.asString().startsWith(Comment.PREFIX);
    }

    @Override
    protected TerminationStrategy getTerminationStrategy() {
        return TerminationStrategy.EXCLUDE_REPROCESS;
    }
}
