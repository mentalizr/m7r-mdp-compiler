package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertExtraction;

public class CommentModelBuilder implements OutlineElementModelBuilder {

    public CommentModelBuilder() {
    }

    @Override
    public CommentModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof CommentExtraction))
            throw new RuntimeException(CommentExtraction.class.getSimpleName() + " expected.");

        return new CommentModel();
    }
}
