package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.Set;

public class ImgCenterModel extends OutlineElementTaggedModel {

    public ImgCenterModel() {
        super(new ImgCenter());
    }

    public ImgCenterAttributes getImgCenterAttributes() {
        return (ImgCenterAttributes) this.mdpTag.getAttributes();
    }

    @Override
    public Set<String> getMediaResources() {
        return Set.of(this.mdpTag.getLinkString());
    }

}
