package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

public class VideoModel extends OutlineElementTaggedModel {

    public VideoModel() {
        super(new Video());
    }

    public VideoAttributes getVideoAttributes() {
        return (VideoAttributes) this.mdpTag.getAttributes();
    }

}
