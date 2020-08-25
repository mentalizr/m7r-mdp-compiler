package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

public class CommentModelBuilder implements OutlineElementModelBuilder {

    public CommentModelBuilder() {
    }

    @Override
    public CommentModel getModel() throws MDPSyntaxError {
        return new CommentModel();
    }
}
