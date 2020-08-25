package org.mentalizr.mdpCompiler.attributeProfile;

import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.attributeProfile.validator.StringWithExclusions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AttributeProfileOpenSimpleTest {

    @Test
    void validate() {

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

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet, true);
        AttributeProfile attributeProfile = new AttributeProfile(attributeSpecs);

        try {
            Attributes attributes = new AttributesBuilder()
                    .addAttribute("name1", "value1")
                    .addAttribute("name2", "value2")
                    .addSimpleAttribute("mySimple")
                    .addSimpleAttribute("myOtherSimple")
                    .build();

            Attributes attributesValidated = attributeProfile.validate(attributes);

            assertTrue(attributesValidated.hasAttribute("name1"));
            assertTrue(attributesValidated.hasAttribute("name2"));

            assertTrue(attributesValidated.hasAttribute("mySimple"));
            assertTrue(attributesValidated.hasAttribute("myOtherSimple"));

            assertEquals(4, attributesValidated.getNrOfAttributes());

            Attributes attributesOpenSimple = attributeProfile.extractOpenSimple(attributesValidated);

            assertTrue(attributesOpenSimple.hasAttribute("mySimple"));
            assertTrue(attributesOpenSimple.hasAttribute("myOtherSimple"));
            assertEquals(2, attributesOpenSimple.getNrOfAttributes());

        } catch (AttributeProfileException e) {
            fail(e);
        }
    }

    @Test
    void emptyOpenSimpleAttributesWhenAttributesProfileNotConfiguredForOpenSimple() {

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
                    .build();

            Attributes attributesValidated = attributeProfile.validate(attributes);
            Attributes attributesOpenSimple = attributeProfile.extractOpenSimple(attributesValidated);

            assertEquals(0, attributesOpenSimple.getNrOfAttributes());

        } catch (AttributeProfileException e) {
            fail(e);
        }
    }

}