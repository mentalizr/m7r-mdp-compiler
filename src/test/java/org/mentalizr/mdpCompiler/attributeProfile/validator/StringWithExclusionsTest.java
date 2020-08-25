package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringWithExclusionsTest {

    @Test
    void plausibility1() {

        StringWithExclusions stringWithExclusions = new StringWithExclusions(".");
        Attribute attribute = new Attribute("name", "value");

        try {
            stringWithExclusions.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

    @Test
    void plausibility2() {

        StringWithExclusions stringWithExclusions = new StringWithExclusions(".");
        Attribute attribute = new Attribute("name", "value.something");

        try {
            stringWithExclusions.validate(attribute);
            fail("exception expected");
        } catch (AttributeValidationException e) {
            System.out.println(e.getMessage());
            // din
        }
    }


}