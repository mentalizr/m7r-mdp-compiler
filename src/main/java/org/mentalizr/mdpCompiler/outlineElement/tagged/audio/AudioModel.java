package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

public class AudioModel extends OutlineElementTaggedModel {

    public AudioAttributes getAudioAttributes() {
        return (AudioAttributes) this.mdpTag.getAttributes();
    }

}
