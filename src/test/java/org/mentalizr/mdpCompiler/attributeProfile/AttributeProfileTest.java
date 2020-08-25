package org.mentalizr.mdpCompiler.attributeProfile;

import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AttributeProfileTest {

    @Test
    void plausibility_pos() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();
        attributeSpecSet.add(new AttributeSpecBuilder("name1").build());
        attributeSpecSet.add(new AttributeSpecBuilder("name2").isRequired().build());
        attributeSpecSet.add(new AttributeSpecBuilder("name3").build());
        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);


        AttributeProfile attributeProfile = new AttributeProfile(attributeSpecs);

        try {

            Attributes attributes = new AttributesBuilder()
                    .addAttribute("name1", "value")
                    .addAttribute("name2", "value")
                    .build();

            Attributes attributesProfiled = attributeProfile.validate(attributes);

            assertNotNull(attributesProfiled);
            assertEquals(2, attributesProfiled.getNrOfAttributes());
            assertTrue(attributesProfiled.hasAttribute("name1"));

            Attribute attributeName1 = attributesProfiled.getAttribute("name1");
            assertEquals("value", attributeName1.getValue());
            assertFalse(attributeName1.isSimpleAttribute());
            assertFalse(attributeName1.hasEmptyValue());

        } catch (AttributeProfileException e) {
            fail(e);
        }
    }

    @Test
    void plausibility_requiredMissing() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();
        attributeSpecSet.add(new AttributeSpecBuilder("name1").build());
        attributeSpecSet.add(new AttributeSpecBuilder("name2").isRequired().build());
        attributeSpecSet.add(new AttributeSpecBuilder("name3").build());
        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        AttributeProfile attributeProfile = new AttributeProfile(attributeSpecs);

        try {

            Attributes attributes = new AttributesBuilder()
                    .addAttribute("name1", "value")
                    .build();

            Attributes attributesProfiled = attributeProfile.validate(attributes);

        } catch (RequiredAttributeMissingException e) {

            System.out.println(e.getMessage());

            assertEquals("name2", e.getAttributeName());

        } catch (AttributeProfileException e) {
            fail(e);
        }
    }

}