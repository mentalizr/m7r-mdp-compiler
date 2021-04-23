package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

public class CommentModelBuilder extends OutlineElementModelBuilder {

    public CommentModelBuilder() {
        super(new Comment());
    }

    @Override
    public CommentModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof CommentExtraction))
            throw new RuntimeException(CommentExtraction.class.getSimpleName() + " expected.");

        return new CommentModel();
    }
}
