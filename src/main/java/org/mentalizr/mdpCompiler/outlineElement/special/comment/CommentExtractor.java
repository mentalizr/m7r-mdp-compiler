package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class CommentExtractor extends OutlineElementExtractor {

    public CommentExtractor() {
        super(new CommentExtractionFactory());
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
