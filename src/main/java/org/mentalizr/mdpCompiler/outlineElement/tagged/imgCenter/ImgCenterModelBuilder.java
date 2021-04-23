package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

public class ImgCenterModelBuilder extends OutlineElementTaggedModelBuilder {

    public ImgCenterModelBuilder() {
        super(new ImgCenter());
    }

    @Override
    public ImgCenterModel getModel(Extraction extraction) throws MDPSyntaxError {

        ImgCenterModel imgCenterModel = new ImgCenterModel();

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        imgCenterModel.setMdpTag(mdpTag);

        return imgCenterModel;
    }

}
