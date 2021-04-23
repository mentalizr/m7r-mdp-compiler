package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroup;

public class TextareaGroup extends FormGroup {

    public static final String TAG = "@textarea-group";

    public TextareaGroup() {
        super(TAG);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new TextareaGroupExtractor();
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new TextareaGroupAttributesFactory();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new TextareaGroupRenderer();
    }

}
