package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParser;
import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfile;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.Attributes;

public abstract class OutlineElementTaggedAttributesParser {

    protected final Attributes attributes;
    protected final Attributes openSimpleAttributes;

    public OutlineElementTaggedAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        Attributes attributes = AttributeParser.parse(attributeString);
        AttributeProfile attributeProfile = getAttributeProfile();
        this.attributes = attributeProfile.validate(attributes);
        this.openSimpleAttributes = attributeProfile.extractOpenSimple(this.attributes);
    }

    public abstract OutlineElementTaggedAttributes getOutlineElementTaggedAttributes();

    protected abstract AttributeProfile getAttributeProfile();

}
