package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.validator.AttributeValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MCQuestionAttributesParserTest {

    @Test
    void validID() throws AttributeParserException, AttributeProfileException {

        String attributeString = "id=\"validId\"";

        MCQuestionAttributesParser mcQuestionAttributesParser = new MCQuestionAttributesParser(attributeString);
        MCQuestionAttributes mcQuestionAttributes = mcQuestionAttributesParser.getOutlineElementTaggedAttributes();

        assertTrue(mcQuestionAttributes.hasId());
        assertEquals("validId", mcQuestionAttributes.getId());

    }

    @Test
    void invalidID() throws AttributeParserException {

        String attributeString = "id=\"4711\"";

        try {
            new MCQuestionAttributesParser(attributeString);
            fail("exception expected.");

        } catch (AttributeProfileException e) {
            assertTrue(e instanceof AttributeValidationException);
        }
    }

    @Test
    void defaultType() throws AttributeParserException, AttributeProfileException {

        MCQuestionAttributesParser mcQuestionAttributesParser = new MCQuestionAttributesParser("");
        MCQuestionAttributes mcQuestionAttributes = mcQuestionAttributesParser.getOutlineElementTaggedAttributes();

        assertEquals(MCQuestionAttributes.TYPE_VALUE_AUTO, mcQuestionAttributes.getType());
    }

}