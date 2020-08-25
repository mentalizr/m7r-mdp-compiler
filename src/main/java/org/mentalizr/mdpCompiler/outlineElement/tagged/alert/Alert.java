package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class Alert extends OutlineElementTagged {

    public static final String TAG = "@alert";

    public Alert(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        super(TAG, result, documentIterator);
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new AlertLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        AlertAttributes alertAttributes = (AlertAttributes) this.outlineElementTaggedAttributes;
        return new AlertModelBuilder(alertAttributes, this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        AlertAttributes alertAttributes = (AlertAttributes) this.outlineElementTaggedAttributes;
        AlertModel alertModel = (AlertModel) this.outlineElementModel;
        return new AlertRenderer(this.result, alertAttributes, alertModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new AlertAttributesFactory();
    }
}
