package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

public interface OutlineElementAttributeParser {

    public OutlineElementTaggedAttributesParser parse(String attributeString) throws AttributeParserException, AttributeProfileException;
}
