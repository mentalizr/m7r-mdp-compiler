package org.mentalizr.mdpCompiler.attributeProfile;

import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.attributeProfile.validator.StringWithExclusions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class AttributeProfileMultipleSimpleTest {

    private AttributeProfile buildAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder("id")
                .isRequired()
                .withNoEmptyValue()
                .withValidator(new StringWithExclusions("."))
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder("name")
                .withNoEmptyValue()
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet, true);
        return new AttributeProfile(attributeSpecs);
    }

    @Test
    void validate() {

        AttributeProfile attributeProfile = buildAttributeProfile();


        try {
            Attributes attributes = new AttributesBuilder()
                    .addAttribute("id", "4711")
                    .addAttribute("name", "myName")
                    .addSimpleAttribute("simple1")
                    .addSimpleAttribute("simple2")
                    .addSimpleAttribute("simple3")
                    .build();

            Attributes attributesValidated = attributeProfile.validate(attributes);

            assertTrue(attributesValidated.hasAttribute("simple1"));
            assertTrue(attributesValidated.hasAttribute("simple2"));
            assertTrue(attributesValidated.hasAttribute("simple3"));

        } catch (AttributeProfileException e) {
            System.out.println(e.getMessage());
            fail(e);
        }
    }

}