package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalTypeTest {

    @Test
    void plausibilityTest() throws AttributeValidationException {

        DecimalType decimalType = new DecimalType();
        Attribute attribute = new Attribute("name", "0.5");

        decimalType.validate(attribute);
    }

    @Test
    void zeroEndingsTest() throws AttributeValidationException {

        DecimalType decimalType = new DecimalType();
        Attribute attribute = new Attribute("name", "0.500000");

        decimalType.validate(attribute);
    }

    @Test
    void integerTest() throws AttributeValidationException {

        DecimalType decimalType = new DecimalType();
        Attribute attribute = new Attribute("name", "5");

        decimalType.validate(attribute);
    }

    @Test
    void negativeValueTest() throws AttributeValidationException {

        DecimalType decimalType = new DecimalType();
        Attribute attribute = new Attribute("name", "-0.5");

        decimalType.validate(attribute);
    }

    @Test
    void negative_stringTest() {

        DecimalType decimalType = new DecimalType();
        Attribute attribute = new Attribute("name", "myString");

        try {
            decimalType.validate(attribute);
            fail("Exception exptected.");
        } catch (AttributeValidationException e) {
            // din
        }
    }

}