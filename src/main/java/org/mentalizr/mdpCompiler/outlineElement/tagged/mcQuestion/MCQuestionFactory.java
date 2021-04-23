package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class MCQuestionFactory extends OutlineElementFactory {

    public MCQuestionFactory() {
        super(MCQuestion.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new MCQuestion();
    }
}
