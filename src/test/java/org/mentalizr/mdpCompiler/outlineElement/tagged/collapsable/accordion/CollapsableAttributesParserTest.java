package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.validator.AttributeValidationException;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributesParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollapsableAttributesParserTest {

    @Test
    void validID() throws AttributeParserException, AttributeProfileException {

        String attributeString = "id=\"validId\"";

        CollapsableAttributesParser collapsableAttributesParser = new CollapsableAttributesParser(attributeString);
        CollapsableAttributes collapsableAttributes = collapsableAttributesParser.getOutlineElementTaggedAttributes();

        assertTrue(collapsableAttributes.hasId());
        assertEquals("validId", collapsableAttributes.getId());

    }

    @Test
    void invalidID() throws AttributeParserException {

        String attributeString = "id=\"4711\"";

        try {
            new CollapsableAttributesParser(attributeString);
            fail("exception expected.");

        } catch (AttributeProfileException e) {
            assertTrue(e instanceof AttributeValidationException);
        }
    }

}