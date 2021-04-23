package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class MCQuestion extends OutlineElementTagged {

    public static final String TAG = "@mc-question";

    public MCQuestion() {
        super(TAG);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new McQuestionExtractor();
    }

    @Override
    protected OutlineElementTaggedModelBuilder getOutlineElementModelBuilder() {
        return new MCQuestionModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new MCQuestionRenderer();
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new MCQuestionAttributesFactory();
    }

}
