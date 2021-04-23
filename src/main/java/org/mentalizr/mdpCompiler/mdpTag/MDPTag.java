package org.mentalizr.mdpCompiler.mdpTag;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

public abstract class MDPTag {

    protected final OutlineElementTagged outlineElementTagged;
    protected final Line line;
    protected String pre;
    protected String attributeString;
    protected String post;
    protected String linkString;
    protected OutlineElementTaggedAttributes attributes;

    public MDPTag(OutlineElementTagged outlineElementTagged, Line line) {
        this.outlineElementTagged = outlineElementTagged;
        this.line = line;
    }

    protected String getTagName() {
        return this.outlineElementTagged.getTagName();
    }

    protected void createAttributes() throws MDPSyntaxError {
        try {
            OutlineElementTaggedAttributesFactory outlineElementTaggedAttributesFactory
                    = outlineElementTagged.getOutlineElementTaggedAttributesFactory();
            OutlineElementTaggedAttributesParser outlineElementTaggedAttributesParser
                    = outlineElementTaggedAttributesFactory.createMDPTagAttributes(this.attributeString);
            this.attributes = outlineElementTaggedAttributesParser.getOutlineElementTaggedAttributes();
        } catch (AttributeParserException | AttributeProfileException e) {
            throw new MDPSyntaxError(this.line, e);
        }
    }


    public Line getMdpTagLine() {
        return this.line;
    }

    public String getPre() {
        return this.pre;
    }

    public String getAttributeString() {
        return this.attributeString;
    }

    public String getPost() {
        return this.post;
    }

    public String getLinkString() {
        return this.linkString;
    }

    public OutlineElementTaggedAttributes getAttributes() {
        return this.attributes;
    }

}
