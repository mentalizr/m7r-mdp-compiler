package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class ImgFluidFactory extends OutlineElementFactory {

    public ImgFluidFactory() {
        super(ImgFluid.TAG);
    }

    @Override
    public OutlineElement getInstance(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        return new ImgFluid(documentIterator, result);
    }
}
