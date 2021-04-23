package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroup;

public class RadioGroup extends FormGroup {

    public static final String TAG = "@radio-group";

    public RadioGroup() {
        super(TAG);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new RadioGroupExtractor();
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new RadioGroupAttributesFactory();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new RadioGroupRenderer();
    }
}
