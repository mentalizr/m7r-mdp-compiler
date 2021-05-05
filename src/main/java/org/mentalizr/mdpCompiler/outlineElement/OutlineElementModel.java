package org.mentalizr.mdpCompiler.outlineElement;

import java.util.*;

public abstract class OutlineElementModel {

    protected OutlineElement outlineElement;

    public OutlineElementModel(OutlineElement outlineElement) {
        this.outlineElement = outlineElement;
    }

    public OutlineElement getOutlineElement() {
        return this.outlineElement;
    }

    public Set<String> getMediaResources() {
        return Collections.emptySet();
    }

}
