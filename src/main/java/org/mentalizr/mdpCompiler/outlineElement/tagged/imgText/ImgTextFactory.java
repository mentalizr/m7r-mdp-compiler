package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class ImgTextFactory extends OutlineElementFactory {

    public ImgTextFactory() {
        super(ImgText.TAG);
    }

    @Override
    public OutlineElement getInstance(Line tagLine) throws MDPSyntaxError {
        return new ImgText(tagLine);
    }
}
