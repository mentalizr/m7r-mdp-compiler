package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class ImgFluidModelBuilder implements OutlineElementModelBuilder {

    public ImgFluidModelBuilder(ImgFluidAttributes imgFluidAttributes, List<Line> lines) {
    }

    @Override
    public ImgFluidModel getModel() throws MDPSyntaxError {
        return new ImgFluidModel();
    }

}
