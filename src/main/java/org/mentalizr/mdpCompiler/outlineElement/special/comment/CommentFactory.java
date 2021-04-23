package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class CommentFactory extends OutlineElementFactory {

    public CommentFactory() {
        super(Comment.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new Comment();
    }
}
