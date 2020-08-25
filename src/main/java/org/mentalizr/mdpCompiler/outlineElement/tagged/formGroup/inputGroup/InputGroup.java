package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.result.Result;

public class InputGroup extends FormGroup {

    public static final String TAG = "@input-group";

    public InputGroup(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        super(TAG, result, documentIterator);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new InputGroupAttributesFactory();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        InputGroupAttributes inputGroupAttributes = (InputGroupAttributes) this.outlineElementTaggedAttributes;
        TextBlockModel textBlockModel = (TextBlockModel) this.outlineElementModel;
        return new InputGroupRenderer(this.result, inputGroupAttributes, textBlockModel);
    }
}
