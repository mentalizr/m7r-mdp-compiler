package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class ImgFluidFactory extends OutlineElementFactory {

    public ImgFluidFactory() {
        super(ImgFluid.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new ImgFluid();
    }
}
