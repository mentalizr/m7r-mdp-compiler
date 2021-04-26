package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

public class ImgCenterModel extends OutlineElementTaggedModel {

    public ImgCenterModel() {
        super(new ImgCenter());
    }

    public ImgCenterAttributes getImgCenterAttributes() {
        return (ImgCenterAttributes) this.mdpTag.getAttributes();
    }

}
