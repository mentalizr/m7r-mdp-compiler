package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.Set;

public class VideoModel extends OutlineElementTaggedModel {

    public VideoModel() {
        super(new Video());
    }

    public VideoAttributes getVideoAttributes() {
        return (VideoAttributes) this.mdpTag.getAttributes();
    }

    @Override
    public Set<String> getMediaResources() {
        return Set.of(this.mdpTag.getLinkString());
    }

}
