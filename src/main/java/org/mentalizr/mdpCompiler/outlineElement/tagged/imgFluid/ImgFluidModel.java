package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.Set;

public class ImgFluidModel extends OutlineElementTaggedModel {

    public ImgFluidModel() {
        super(new ImgFluid());
    }

    public ImgFluidAttributes getImgFluidAttributes() {
        return (ImgFluidAttributes) this.mdpTag.getAttributes();
    }

    @Override
    public Set<String> getMediaResources() {
        return Set.of(this.mdpTag.getLinkString());
    }

}
