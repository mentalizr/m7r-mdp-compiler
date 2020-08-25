package org.mentalizr.mdpCompiler.attributeProfile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttributeTest {

    @Test
    void pos_1() {

        Attribute attribute = new Attribute("myName", "myValue");

        assertEquals("myName", attribute.getName());
        assertEquals("myValue", attribute.getValue());
        assertFalse(attribute.isSimpleAttribute());
        assertFalse(attribute.hasEmptyValue());
    }

    @Test
    void empty() {

        Attribute attribute = new Attribute("myName", "");

        assertEquals("myName", attribute.getName());
        assertEquals("", attribute.getValue());
        assertFalse(attribute.isSimpleAttribute());
        assertTrue(attribute.hasEmptyValue());
    }

    @Test
    void simple_pos_1() {
        Attribute attribute = new Attribute("myName", null);

        assertEquals("myName", attribute.getName());
        assertTrue(attribute.isSimpleAttribute());
    }

}