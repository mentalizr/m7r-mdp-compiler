package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class H1Factory extends OutlineElementFactory {

    public H1Factory() {
        super(H1.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new H1();
    }
}
