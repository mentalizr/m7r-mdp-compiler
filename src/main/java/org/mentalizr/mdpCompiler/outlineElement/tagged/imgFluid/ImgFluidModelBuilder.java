package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

public class ImgFluidModelBuilder extends OutlineElementTaggedModelBuilder {

    public ImgFluidModelBuilder() {
        super(new ImgFluid());
    }

    @Override
    public ImgFluidModel getModel(Extraction extraction) throws MDPSyntaxError {

        ImgFluidModel imgFluidModel = new ImgFluidModel();

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        imgFluidModel.setMdpTag(mdpTag);

        return imgFluidModel;
    }

}
