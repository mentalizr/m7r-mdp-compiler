package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class H5Factory extends OutlineElementFactory {

    public H5Factory() {
        super(H5.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new H5();
    }
}
