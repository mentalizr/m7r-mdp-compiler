package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter.ImgCenterExtractionFactory;

public class ImgFluidExtractor extends MDPTagOnlyExtractor {

    public ImgFluidExtractor() {
        super(new ImgFluidExtractionFactory());
    }

}
