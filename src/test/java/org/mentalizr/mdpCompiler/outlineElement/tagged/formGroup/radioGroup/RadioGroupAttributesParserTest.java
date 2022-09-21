package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RadioGroupAttributesParserTest {

    @Test
    void plausibility() throws AttributeParserException, AttributeProfileException {

        String attributeString = "name=\"myRadioGroup\" id=\"myRadioButtonId\" \"itemOne\" \"itemTwo\" \"itemThree\"";

        RadioGroupAttributesParser radioGroupAttributesParser = new RadioGroupAttributesParser(attributeString);
        RadioGroupAttributes radioGroupAttributes = radioGroupAttributesParser.getOutlineElementTaggedAttributes();

        assertEquals("myRadioButtonId", radioGroupAttributes.getId());
        assertEquals("myRadioGroup", radioGroupAttributes.getName());

        List<String> openSimpleAttributes = radioGroupAttributes.getOpenSimpleAttributes();

        assertEquals(3, openSimpleAttributes.size());
        assertEquals("itemOne", openSimpleAttributes.get(0));
        assertEquals("itemTwo", openSimpleAttributes.get(1));
        assertEquals("itemThree", openSimpleAttributes.get(2));
    }

}