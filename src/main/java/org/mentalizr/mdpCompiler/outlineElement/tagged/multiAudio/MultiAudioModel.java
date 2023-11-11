package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultiAudioModel extends OutlineElementTaggedModel {

    private Set<String> audioResources;

    public MultiAudioModel(Set<String> audioResources) {
        super(new MultiAudio());
        this.audioResources = audioResources;
    }

    public MultiAudioAttributes getAudioAttributes() {
        return (MultiAudioAttributes) this.mdpTag.getAttributes();
    }

    @Override
    public Set<String> getMediaResources() {
        return this.audioResources;
    }

}
