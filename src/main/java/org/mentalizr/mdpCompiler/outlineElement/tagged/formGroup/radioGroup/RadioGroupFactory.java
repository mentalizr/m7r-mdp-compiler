package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class RadioGroupFactory extends OutlineElementFactory {

    public RadioGroupFactory() {
        super(RadioGroup.TAG);
    }

    @Override
    public OutlineElement getInstance(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        return new RadioGroup(documentIterator, result);
    }
}
