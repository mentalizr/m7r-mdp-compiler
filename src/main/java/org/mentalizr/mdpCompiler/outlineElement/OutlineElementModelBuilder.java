package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPSyntaxError;

public abstract class OutlineElementModelBuilder {

    protected OutlineElement outlineElement;

    public OutlineElementModelBuilder(OutlineElement outlineElement) {
        this.outlineElement = outlineElement;
    }

    public OutlineElement getOutlineElement() {
        return this.outlineElement;
    }

    public abstract OutlineElementModel getModel(Extraction extraction) throws MDPSyntaxError;

}
