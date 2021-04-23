package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class ImgTextFactory extends OutlineElementFactory {

    public ImgTextFactory() {
        super(ImgText.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new ImgText();
    }
}
