package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

public class MCQuestionAttributesFactory implements OutlineElementTaggedAttributesFactory {

    @Override
    public OutlineElementTaggedAttributesParser createMDPTagAttributes(String attributesString) throws AttributeParserException, AttributeProfileException {
        return new MCQuestionAttributesParser(attributesString);
    }
}
