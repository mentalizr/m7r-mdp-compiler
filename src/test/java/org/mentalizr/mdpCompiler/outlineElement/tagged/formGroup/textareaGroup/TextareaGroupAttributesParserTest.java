package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextareaGroupAttributesParserTest {

    @Test
    void plausibility1() throws AttributeParserException, AttributeProfileException {

        String attributeString = "id=\"1\"";

        TextareaGroupAttributesParser textareaGroupAttributesParser = new TextareaGroupAttributesParser(attributeString);
        TextareaGroupAttributes textareaGroupAttributes = (TextareaGroupAttributes) textareaGroupAttributesParser.getOutlineElementTaggedAttributes();

        assertEquals("1", textareaGroupAttributes.getId());
        assertEquals("3", textareaGroupAttributes.getRows());
    }

    @Test
    void plausibility2() throws AttributeParserException, AttributeProfileException {

        String attributeString = "id=\"1\" rows=\"77\"";

        TextareaGroupAttributesParser textareaGroupAttributesParser = new TextareaGroupAttributesParser(attributeString);
        TextareaGroupAttributes textareaGroupAttributes = (TextareaGroupAttributes) textareaGroupAttributesParser.getOutlineElementTaggedAttributes();

        assertEquals("1", textareaGroupAttributes.getId());
        assertEquals("77", textareaGroupAttributes.getRows());
    }

}