package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTypeTest {

    @Test
    void positive() {

        IntegerType integerType = new IntegerType();
        Attribute attribute = new Attribute("name", "42");

        try {
            integerType.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

    @Test
    void positive_negativeValue() {

        IntegerType integerType = new IntegerType();
        Attribute attribute = new Attribute("name", "-42");

        try {
            integerType.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }


    @Test
    void negative1() {

        IntegerType integerType = new IntegerType();
        Attribute attribute = new Attribute("name", "42.34");

        try {
            integerType.validate(attribute);
            fail("exception expected.");
        } catch (AttributeValidationException e) {
            // din
        }
    }

    @Test
    void negative2() {

        IntegerType integerType = new IntegerType();
        Attribute attribute = new Attribute("name", "dummy");

        try {
            integerType.validate(attribute);
            fail("exception expected.");
        } catch (AttributeValidationException e) {
            // din
        }
    }

}