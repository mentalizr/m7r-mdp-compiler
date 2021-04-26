package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

public class ImgFluidModel extends OutlineElementTaggedModel {

    public ImgFluidModel() {
        super(new ImgFluid());
    }

    public ImgFluidAttributes getImgFluidAttributes() {
        return (ImgFluidAttributes) this.mdpTag.getAttributes();
    }

}
