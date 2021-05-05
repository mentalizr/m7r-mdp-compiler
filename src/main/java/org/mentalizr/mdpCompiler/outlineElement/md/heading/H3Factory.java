package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class H3Factory extends OutlineElementFactory {

    public H3Factory() {
        super(H3.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new H3();
    }
}
