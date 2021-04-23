package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class ULFactory extends OutlineElementFactory {

    public ULFactory() {
        super(UL.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new UL();
    }
}
