package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.result.Result;

public class RadioGroup extends FormGroup {

    public static final String TAG = "@radio-group";

    public RadioGroup(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        super(TAG, result, documentIterator);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new RadioGroupAttributesFactory();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        RadioGroupAttributes radioGroupAttributes = (RadioGroupAttributes) this.outlineElementTaggedAttributes;
        TextBlockModel textBlockModel = (TextBlockModel) this.outlineElementModel;
        return new RadioGroupRenderer(this.result, radioGroupAttributes, textBlockModel);
    }
}
