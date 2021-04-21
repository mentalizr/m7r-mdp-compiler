package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class Comment extends OutlineElement {

    public static final String PREFIX = "//";

    public Comment() {
        super(PREFIX);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new CommentExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new CommentModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        CommentModel commentModel = (CommentModel) this.outlineElementModel;
        return new CommentRenderer(commentModel);
    }
}
