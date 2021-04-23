package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class HRFactory extends OutlineElementFactory {

    public HRFactory() {
        super(HR.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new HR();
    }
}
