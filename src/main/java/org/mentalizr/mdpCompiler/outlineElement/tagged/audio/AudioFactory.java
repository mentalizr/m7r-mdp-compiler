package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class AudioFactory extends OutlineElementFactory {

    public AudioFactory() {
        super(Audio.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new Audio();
    }
}
