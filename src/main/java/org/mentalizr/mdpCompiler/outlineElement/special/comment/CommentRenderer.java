package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class CommentRenderer extends OutlineElementRenderer {

    private final CommentModel commentModel;

    public CommentRenderer(CommentModel commentModel) {
        super();
        this.commentModel = commentModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {
    }

}
