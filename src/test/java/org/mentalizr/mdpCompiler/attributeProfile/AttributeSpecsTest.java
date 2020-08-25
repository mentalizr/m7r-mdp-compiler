package org.mentalizr.mdpCompiler.attributeProfile;

import de.arthurpicht.utils.core.collection.Sets;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.attributeProfile.validator.StringWithExclusions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AttributeSpecsTest {

    @Test
    void getAttributeSpec() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();
        attributeSpecSet.add(new AttributeSpecBuilder("name1").build());
        attributeSpecSet.add(new AttributeSpecBuilder("name2").isRequired().build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        attributeSpecs.getAttributeSpec("name1");
    }

    @Test
    void hasAttributeSpec() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder("name1")
                .isRequired()
                .withNoEmptyValue()
                .withValidator(new StringWithExclusions("."))
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder("name2")
                .withNoEmptyValue()
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder("name3")
                .isSimple()
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        assertTrue(attributeSpecs.hasAttributeSpec("name1"));
        assertTrue(attributeSpecs.hasAttributeSpec("name2"));
        assertTrue(attributeSpecs.hasAttributeSpec("name3"));
        assertFalse(attributeSpecs.hasAttributeSpec("someName"));
    }

    @Test
    void allowOpenSimple() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();
        attributeSpecSet.add(new AttributeSpecBuilder("name1").build());
        attributeSpecSet.add(new AttributeSpecBuilder("name2").isRequired().build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);
        assertFalse(attributeSpecs.isAllowOpenSimpleAttributes());

        attributeSpecs = new AttributeSpecs(attributeSpecSet, true);
        assertTrue(attributeSpecs.isAllowOpenSimpleAttributes());
    }

    @Test
    void getAttributeSpec_negative() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();
        attributeSpecSet.add(new AttributeSpecBuilder("name1").build());
        attributeSpecSet.add(new AttributeSpecBuilder("name2").isRequired().build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        try {
            attributeSpecs.getAttributeSpec("unknownName");
            fail("exception expected");
        } catch (IllegalArgumentException e) {
            // din
        }
    }

    @Test
    void getNamesOfRequired() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();
        attributeSpecSet.add(new AttributeSpecBuilder("name1").build());
        attributeSpecSet.add(new AttributeSpecBuilder("name2").isRequired().build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        Set<String> requiredAttributes = attributeSpecs.getNamesOfRequired();

        assertNotNull(requiredAttributes);
        assertEquals(1, requiredAttributes.size());

        AttributeSpec attributeSpec = attributeSpecs.getAttributeSpec(Sets.getSomeElement(requiredAttributes));
        assertEquals("name2", attributeSpec.getAttributeName());
    }

    @Test
    void getNamesOfNotSetAttributes() throws AttributeProfileException {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();
        attributeSpecSet.add(new AttributeSpecBuilder("name1").build());
        attributeSpecSet.add(new AttributeSpecBuilder("name2").isRequired().build());
        attributeSpecSet.add(new AttributeSpecBuilder("name3").build());
        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        Attributes attributes = new AttributesBuilder()
                .addAttribute("name1", "value")
                .addAttribute("name2", "value")
                .build();

        Set<String> namesOfNotSetAttributes = attributeSpecs.getNamesOfNotSetAttributes(attributes);

        assertEquals(1, namesOfNotSetAttributes.size());

        String attributeName = Sets.getSomeElement(namesOfNotSetAttributes);
        assertNotNull(attributeName);
        assertEquals("name3", attributeName);
    }

}