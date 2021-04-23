package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class TextareaGroupFactory extends OutlineElementFactory {

    public TextareaGroupFactory() {
        super(TextareaGroup.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new TextareaGroup();
    }
}
