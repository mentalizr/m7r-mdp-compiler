package org.mentalizr.mdpCompiler.attributeProfile;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.attributeProfile.validator.AttributeValidationException;
import org.mentalizr.mdpCompiler.attributeProfile.validator.PositiveInteger;
import org.mentalizr.mdpCompiler.attributeProfile.validator.PredefinedStrings;
import org.mentalizr.mdpCompiler.attributeProfile.validator.StringWithExclusions;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class AttributeProfileIntegrationTest {

    private AttributeProfile buildAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder("id")
                .isRequired()
                .withNoEmptyValue()
                .withValidator(new StringWithExclusions("."))
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder("formtype")
                .withDefaultValue("input")
                .withValidator(new PredefinedStrings("input", "textarea"))
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder("inputtype")
                .withDefaultValue("text")
                .withValidator(new PredefinedStrings("date", "time", "text"))
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder("rows")
                .withDefaultValue("3")
                .withNoEmptyValue()
                .withValidator(new PositiveInteger())
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder("placeholder")
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);
        return new AttributeProfile(attributeSpecs);
    }

    @Test
    void idOnly_positive() {

        AttributeProfile attributeProfile = buildAttributeProfile();

        try {

            Attributes attributes = new AttributesBuilder()
                    .addAttribute("id", "4711")
                    .build();

            Attributes attributesValidated = attributeProfile.validate(attributes);

            assertNotNull(attributesValidated);
            assertEquals(4, attributesValidated.getNrOfAttributes());

            assertTrue(attributesValidated.hasAttribute("id"));
            assertEquals("4711", attributesValidated.getAttribute("id").getValue());

            assertTrue(attributesValidated.hasAttribute("formtype"));
            assertEquals("input", attributesValidated.getAttribute("formtype").getValue());

            assertTrue(attributesValidated.hasAttribute("rows"));

        } catch (AttributeProfileException e) {
            e.printStackTrace();
        }
    }

    @Test
    void idWithIllegalDot_negative() {

        AttributeProfile attributeProfile = buildAttributeProfile();

        try {
            Attributes attributes = new AttributesBuilder()
                    .addAttribute("id", "4711.something")
                    .build();

            Attributes attributesValidated = attributeProfile.validate(attributes);
            fail("exception expected");
        } catch (AttributeProfileException e) {
            assertTrue(e instanceof AttributeValidationException);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void missingRequiredId() {

        AttributeProfile attributeProfile = buildAttributeProfile();

        Attributes attributes = new AttributesBuilder().build();

        try {
            attributeProfile.validate(attributes);
            fail("exception expected");
        } catch (AttributeProfileException e) {
            assertTrue(e instanceof RequiredAttributeMissingException);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void formtype_positive() throws AttributeProfileException {

        AttributeProfile attributeProfile = buildAttributeProfile();

        Attributes attributes = new AttributesBuilder()
                .addAttribute("id", "4711")
                .addAttribute("formtype", "textarea")
                .build();

        Attributes attributesValidated = attributeProfile.validate(attributes);

        assertTrue(attributesValidated.hasAttribute("id"));
        assertTrue(attributesValidated.hasAttribute("formtype"));
        assertEquals("textarea", attributesValidated.getAttribute("formtype").getValue());
    }

    @Test
    void illegalFormtype() {

        AttributeProfile attributeProfile = buildAttributeProfile();

        try {
            Attributes attributes = new AttributesBuilder()
                    .addAttribute("id", "4711")
                    .addAttribute("formtype", "rubish")
                    .build();

            attributeProfile.validate(attributes);
            fail("exception expected");
        } catch (AttributeProfileException e) {
            assertTrue(e instanceof AttributeValidationException);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void emptyFormtype() {

        AttributeProfile attributeProfile = buildAttributeProfile();

        try {
            Attributes attributes = new AttributesBuilder()
                    .addAttribute("id", "4711")
                    .addAttribute("formtype", "")
                    .build();

            attributeProfile.validate(attributes);
            fail("exception expected");
        } catch (AttributeProfileException e) {
            assertTrue(e instanceof AttributeValidationException);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void example() throws AttributeProfileException {

        AttributeProfile attributeProfile = buildAttributeProfile();

        Attributes attributes = new AttributesBuilder()
                .addAttribute("id", "4711")
                .addAttribute("formtype", "input")
                .addAttribute("inputtype", "date")
                .addAttribute("placeholder", "")
                .build();

        Attributes attributesValidated = attributeProfile.validate(attributes);

        assertNotNull(attributesValidated);
        assertEquals(5, attributesValidated.getNrOfAttributes());

        assertTrue(attributesValidated.hasAttribute("id"));
        assertEquals("4711", attributesValidated.getAttribute("id").getValue());

        assertTrue(attributesValidated.hasAttribute("formtype"));
        assertEquals("input", attributesValidated.getAttribute("formtype").getValue());

        assertTrue(attributesValidated.hasAttribute("inputtype"));
        assertEquals("date", attributesValidated.getAttribute("inputtype").getValue());

        assertTrue(attributesValidated.hasAttribute("rows"));
        assertEquals("3", attributesValidated.getAttribute("rows").getValue());

        assertTrue(attributesValidated.hasAttribute("placeholder"));
        assertEquals("", attributesValidated.getAttribute("placeholder").getValue());
    }

}