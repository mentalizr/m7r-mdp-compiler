package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class AudioFactory extends OutlineElementFactory {

    public AudioFactory() {
        super(Audio.TAG);
    }

    @Override
    public OutlineElement getInstance(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        return new Audio(documentIterator, result);
    }
}
