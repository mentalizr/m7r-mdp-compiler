package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class TextareaGroupFactory extends OutlineElementFactory {

    public TextareaGroupFactory() {
        super(TextareaGroup.TAG);
    }

    @Override
    public OutlineElement getInstance(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        return new TextareaGroup(documentIterator, result);
    }
}
