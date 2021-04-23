package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class RadioGroupFactory extends OutlineElementFactory {

    public RadioGroupFactory() {
        super(RadioGroup.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new RadioGroup();
    }
}
