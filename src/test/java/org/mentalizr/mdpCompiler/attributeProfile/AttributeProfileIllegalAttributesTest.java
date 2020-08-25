package org.mentalizr.mdpCompiler.attributeProfile;

import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.attributeProfile.validator.StringWithExclusions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AttributeProfileIllegalAttributesTest {

    @Test
    void illegalAttributeAssignment() {

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
        AttributeProfile attributeProfile = new AttributeProfile(attributeSpecs);

        try {
            Attributes attributes = new AttributesBuilder()
                    .addAttribute("name1", "value1")
                    .addAttribute("name2", "value2")
                    .addAttribute("illegalAttribute", "value")
                    .build();

            attributeProfile.validate(attributes);
            fail("Exception exptected.");
        } catch (IllegalAttributeException e) {
            assertEquals("illegalAttribute", e.getAttributeName());
        } catch (AttributeProfileException e) {
            fail(e);
        }
    }

    @Test
    void illegalAttributeSimple() {

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
        AttributeProfile attributeProfile = new AttributeProfile(attributeSpecs);


        try {
            Attributes attributes = new AttributesBuilder()
                    .addAttribute("name1", "value1")
                    .addAttribute("name2", "value2")
                    .addSimpleAttribute("illegalAttribute")
                    .build();

            attributeProfile.validate(attributes);
            fail("Exception exptected.");
        } catch (IllegalAttributeException e) {
            assertEquals("illegalAttribute", e.getAttributeName());
        } catch (AttributeProfileException e) {
            fail(e);
        }
    }

}