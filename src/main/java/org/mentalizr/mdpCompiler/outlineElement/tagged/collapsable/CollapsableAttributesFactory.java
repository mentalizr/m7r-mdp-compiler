package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class CollapsableAttributesFactory implements OutlineElementTaggedAttributesFactory {

    @Override
    public OutlineElementTaggedAttributesParser createMDPTagAttributes(String attributesString) throws AttributeParserException, AttributeProfileException {
        return new CollapsableAttributesParser(attributesString);
    }
}
