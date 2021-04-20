package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class ULFactory extends OutlineElementFactory {

    public ULFactory() {
        super(UL.PREFIX);
    }

    @Override
    public OutlineElement getInstance(Line tagLine) throws MDPSyntaxError {
        return new UL();
    }
}
