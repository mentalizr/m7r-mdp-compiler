package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockLinesExtractor;
import org.mentalizr.mdpCompiler.result.Result;

public class MCQuestion extends OutlineElementTagged {

    public static final String TAG = "@mc-question";

    public MCQuestion(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        super(TAG, result, documentIterator);
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new TextBlockLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        MCQuestionAttributes mcQuestionAttributes = (MCQuestionAttributes) this.outlineElementTaggedAttributes;
        return new MCQuestionModelBuilder(mcQuestionAttributes, this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        MCQuestionAttributes mcQuestionAttributes = (MCQuestionAttributes) this.outlineElementTaggedAttributes;
        MCQuestionModel mcQuestionModel = (MCQuestionModel) this.outlineElementModel;
        return new MCQuestionRenderer(this.result, mcQuestionAttributes, mcQuestionModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new MCQuestionAttributesFactory();
    }

}
