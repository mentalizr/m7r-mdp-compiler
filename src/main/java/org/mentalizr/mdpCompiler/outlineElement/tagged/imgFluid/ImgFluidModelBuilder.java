package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

public class ImgFluidModelBuilder implements OutlineElementModelBuilder {

    public ImgFluidModelBuilder(ImgFluidAttributes imgFluidAttributes) {
    }

    @Override
    public ImgFluidModel getModel(Extraction extraction) throws MDPSyntaxError {
        return new ImgFluidModel();
    }

}
