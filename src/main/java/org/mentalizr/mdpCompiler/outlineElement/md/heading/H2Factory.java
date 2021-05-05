package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class H2Factory extends OutlineElementFactory {

    public H2Factory() {
        super(H2.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new H2();
    }
}
