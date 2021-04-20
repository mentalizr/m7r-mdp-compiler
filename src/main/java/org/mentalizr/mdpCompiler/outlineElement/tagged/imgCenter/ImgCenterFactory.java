package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class ImgCenterFactory extends OutlineElementFactory {

    public ImgCenterFactory() {
        super(ImgCenter.TAG);
    }

    @Override
    public OutlineElement getInstance(Line tagLine) throws MDPSyntaxError {
        return new ImgCenter(tagLine);
    }
}
