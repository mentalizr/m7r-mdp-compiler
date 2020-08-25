package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveDecimalTest {

    @Test
    void plausibilityTest() throws AttributeValidationException {

        PositiveDecimal positiveDecimal = new PositiveDecimal();
        Attribute attribute = new Attribute("name", "0.5");

        positiveDecimal.validate(attribute);
    }

    @Test
    void negativeValue() {

        PositiveDecimal positiveDecimal = new PositiveDecimal();
        Attribute attribute = new Attribute("name", "-0.5");

        try {
            positiveDecimal.validate(attribute);
            fail("Exception exptected.");
        } catch (AttributeValidationException e) {
            System.out.println(e.getMessage());
        }
    }

}