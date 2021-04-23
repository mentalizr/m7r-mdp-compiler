package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroup;

public class InputGroup extends FormGroup {

    public static final String TAG = "@input-group";

    public InputGroup() {
        super(TAG);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new InputGroupExtractor();
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new InputGroupAttributesFactory();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new InputGroupRenderer();
    }
}
