package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredefinedStringsTest {

    @Test
    void plausibility_positive() {

        PredefinedStrings predefinedStrings = new PredefinedStrings("one", "two", "three");
        Attribute attribute = new Attribute("name", "two");

        try {
            predefinedStrings.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

    @Test
    void plausibility_negative() {

        PredefinedStrings predefinedStrings = new PredefinedStrings("one", "two", "three");
        Attribute attribute = new Attribute("name", "dummy");

        try {
            predefinedStrings.validate(attribute);
            fail("exception expected");
        } catch (AttributeValidationException e) {
            // din
        }
    }

}