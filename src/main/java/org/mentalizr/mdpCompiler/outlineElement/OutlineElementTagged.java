package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.mdpTag.MDPTagSimple;
import org.mentalizr.mdpCompiler.mdpTag.MDPTagWithLink;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.result.Result;

public abstract class OutlineElementTagged extends OutlineElement {

    protected Line mdpTagLine;
    protected String tagName;
    protected MDPTag mdpTag;
    protected OutlineElementTaggedAttributes outlineElementTaggedAttributes;

    public OutlineElementTagged(String tagName, Line tagLine) throws MDPSyntaxError {
        super(tagName);
        this.tagName = tagName;
        this.mdpTagLine = tagLine;
        if (withLink()) {
            this.mdpTag = new MDPTagWithLink(this.tagName, this.mdpTagLine);
        } else {
            this.mdpTag = new MDPTagSimple(this.tagName, this.mdpTagLine);
        }
        try {
            OutlineElementTaggedAttributesParser outlineElementTaggedAttributesParser = getOutlineElementTaggedAttributesFactory().createMDPTagAttributes(this.mdpTag.getAttributeString());
            this.outlineElementTaggedAttributes = outlineElementTaggedAttributesParser.getOutlineElementTaggedAttributes();
        } catch (AttributeParserException | AttributeProfileException e) {
            throw new MDPSyntaxError(this.mdpTagLine, e);
        }
    }

    protected boolean withLink() {
        return false;
    }

    protected abstract OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory();

}
