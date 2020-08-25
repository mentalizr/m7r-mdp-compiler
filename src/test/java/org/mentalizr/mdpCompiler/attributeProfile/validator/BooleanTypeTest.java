package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleanTypeTest {

    @Test
    void plausibility_true() {

        BooleanType booleanType = new BooleanType();

        Attribute attribute = new Attribute("name", "true");
        try {
            booleanType.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

    @Test
    void plausibility_false() {

        BooleanType booleanType = new BooleanType();

        Attribute attribute = new Attribute("name", "false");
        try {
            booleanType.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

    @Test
    void plausibility_negative() {

        BooleanType booleanType = new BooleanType();

        Attribute attribute = new Attribute("name", "dummy");
        try {
            booleanType.validate(attribute);
            fail("exception expected");
        } catch (AttributeValidationException e) {
            // din
        }
    }



}