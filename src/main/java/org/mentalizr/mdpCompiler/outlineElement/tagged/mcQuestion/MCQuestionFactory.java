package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class MCQuestionFactory extends OutlineElementFactory {

    public MCQuestionFactory() {
        super(MCQuestion.TAG);
    }

    @Override
    public OutlineElement getInstance(Line tagLIne) throws MDPSyntaxError {
        return new MCQuestion(tagLIne);
    }
}
