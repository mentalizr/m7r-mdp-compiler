package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class H4Factory extends OutlineElementFactory {

    public H4Factory() {
        super(H4.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new H4();
    }
}
