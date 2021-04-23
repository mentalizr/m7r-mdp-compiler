package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class ImgCenterFactory extends OutlineElementFactory {

    public ImgCenterFactory() {
        super(ImgCenter.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new ImgCenter();
    }
}
