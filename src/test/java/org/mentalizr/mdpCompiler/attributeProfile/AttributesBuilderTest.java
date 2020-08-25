package org.mentalizr.mdpCompiler.attributeProfile;

import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttributesBuilderTest {

    @Test
    void plausibility() throws AttributeProfileException {

        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.addAttribute("name1", "value1");
        attributesBuilder.addAttribute(new Attribute("name2", "value2"));
        attributesBuilder.addSimpleAttribute("name3");
        Attributes attributes = attributesBuilder.build();

        assertEquals(3, attributes.getNrOfAttributes());
        assertTrue(attributes.hasAttribute("name1"));
        assertTrue(attributes.hasAttribute("name2"));
        assertTrue(attributes.hasAttribute("name3"));

        Attribute attribute = attributes.getAttribute("name1");
        assertNotNull(attribute);
        assertEquals("value1", attribute.getValue());
        assertFalse(attribute.isSimpleAttribute());

        attribute = attributes.getAttribute("name3");
        assertNotNull(attribute);
        assertTrue(attribute.isSimpleAttribute());
    }

    @Test
    void pos_fluent() throws AttributeProfileException {

        Attributes attributes = new AttributesBuilder()
                .addAttribute("name1", "value1")
                .addAttribute("name2", "value2")
                .addSimpleAttribute("name3")
                .build();

        assertEquals(3, attributes.getNrOfAttributes());
        assertTrue(attributes.hasAttribute("name1"));
        assertTrue(attributes.hasAttribute("name2"));
        assertTrue(attributes.hasAttribute("name3"));

        Attribute attribute = attributes.getAttribute("name1");
        assertNotNull(attribute);
        assertEquals("value1", attribute.getValue());
        assertFalse(attribute.isSimpleAttribute());

        attribute = attributes.getAttribute("name3");
        assertNotNull(attribute);
        assertTrue(attribute.isSimpleAttribute());
    }

    @Test
    void fail_emptyName() {

        AttributesBuilder attributesBuilder = new AttributesBuilder();
        try {
            attributesBuilder.addAttribute("", "value1");
            fail("Exception expected.");
        } catch(AttributeProfileException e) {
            // din
        }
    }

    @Test
    void fail_nullName() {

        AttributesBuilder attributesBuilder = new AttributesBuilder();
        try {
            attributesBuilder.addAttribute(null, "value1");
            fail("Exception expected.");
        } catch(AttributeProfileException e) {
            // din
        }
    }

    @Test
    void fail_doubleDefinition() {

        AttributesBuilder attributesBuilder = new AttributesBuilder();

        try {
            attributesBuilder.addAttribute("name", "value");
        } catch (AttributeProfileException e) {
            fail(e);
        }

        try {
            attributesBuilder.addAttribute("name", "value1");
            fail("Exception expected.");
        } catch(AttributeProfileException e) {
            // din
        }
    }

}

