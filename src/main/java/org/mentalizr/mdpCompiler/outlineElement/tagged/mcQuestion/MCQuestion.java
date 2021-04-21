package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

public class MCQuestion extends OutlineElementTagged {

    public static final String TAG = "@mc-question";

    public MCQuestion(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new McQuestionExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        MCQuestionAttributes mcQuestionAttributes = (MCQuestionAttributes) this.outlineElementTaggedAttributes;
        return new MCQuestionModelBuilder(mcQuestionAttributes);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        MCQuestionAttributes mcQuestionAttributes = (MCQuestionAttributes) this.outlineElementTaggedAttributes;
        MCQuestionModel mcQuestionModel = (MCQuestionModel) this.outlineElementModel;
        return new MCQuestionRenderer(mcQuestionAttributes, mcQuestionModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new MCQuestionAttributesFactory();
    }

}
