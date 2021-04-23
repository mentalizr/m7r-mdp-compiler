package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public abstract class OutlineElementTagged extends OutlineElement {

    public OutlineElementTagged(String tagName) {
        super(tagName);
    }

    public String getTagName() {
        return this.prefix;
    }

    public boolean withLink() {
        return false;
    }

    public abstract OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory();

}
