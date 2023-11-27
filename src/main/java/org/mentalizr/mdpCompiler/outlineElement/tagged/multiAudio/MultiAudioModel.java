package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MultiAudioModel extends OutlineElementTaggedModel {

    public record MultiAudioResource(String label, String source) {}

    private final List<MultiAudioResource> multiAudioResources;
    private final MultiAudioAttributes multiAudioAttributes;

    public MultiAudioModel(List<MultiAudioResource> multiAudioResources, MultiAudioAttributes multiAudioAttributes) {
        super(new MultiAudio());
        this.multiAudioResources = multiAudioResources;
        this.multiAudioAttributes = multiAudioAttributes;
    }

//    public MultiAudioAttributes getAudioAttributes() {
//        return (MultiAudioAttributes) this.mdpTag.getAttributes();
//    }

    public List<MultiAudioResource> getAudioResources() {
        return this.multiAudioResources;
    }

    public MultiAudioAttributes getMultiAudioAttributes() {
        return this.multiAudioAttributes;
    }

    @Override
    public Set<String> getMediaResources() {
        return this.multiAudioResources.stream()
                .map(MultiAudioResource::source)
                .collect(Collectors.toSet());
    }

}
