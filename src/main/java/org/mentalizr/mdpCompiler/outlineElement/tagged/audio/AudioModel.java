package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.Set;

public class AudioModel extends OutlineElementTaggedModel {

    public AudioModel() {
        super(new Audio());
    }

    public AudioAttributes getAudioAttributes() {
        return (AudioAttributes) this.mdpTag.getAttributes();
    }

    @Override
    public Set<String> getMediaResources() {
        return Set.of(this.mdpTag.getLinkString());
    }

}
