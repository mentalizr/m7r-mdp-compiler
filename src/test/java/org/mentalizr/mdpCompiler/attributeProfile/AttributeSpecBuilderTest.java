package org.mentalizr.mdpCompiler.attributeProfile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttributeSpecBuilderTest {

    @Test
    void plausibility_1() {

        AttributeSpec attributeSpec = new AttributeSpecBuilder("name").build();

        assertEquals("name", attributeSpec.getAttributeName());
        assertFalse(attributeSpec.isSimple());
        assertFalse(attributeSpec.isRequired());
        assertFalse(attributeSpec.noEmptyValue());
        assertFalse(attributeSpec.hasDefaultValue());
        assertNull(attributeSpec.getDefaultValue());
        assertFalse(attributeSpec.hasAttributeValidator());
        assertNull(attributeSpec.getAttributeValidator());
    }

    @Test
    void plausibility_required() {

        AttributeSpec attributeSpec = new AttributeSpecBuilder("name")
                .isRequired()
                .build();

        assertEquals("name", attributeSpec.getAttributeName());
        assertFalse(attributeSpec.isSimple());
        assertTrue(attributeSpec.isRequired());
        assertFalse(attributeSpec.noEmptyValue());
        assertFalse(attributeSpec.hasDefaultValue());
        assertNull(attributeSpec.getDefaultValue());
        assertFalse(attributeSpec.hasAttributeValidator());
        assertNull(attributeSpec.getAttributeValidator());
    }

}