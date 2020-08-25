package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveIntegerTest {

    @Test
    void lowerBorder() throws AttributeValidationException {

        PositiveInteger positiveInteger = new PositiveInteger();
        Attribute attribute = new Attribute("name", "2");

        positiveInteger.validate(attribute);
    }


    @Test
    void validate() {

        PositiveInteger positiveInteger = new PositiveInteger();
        Attribute attribute = new Attribute("name", "-2");

        try {
            positiveInteger.validate(attribute);
            fail("exception expected.");
        } catch (AttributeValidationException e) {
            System.out.println(e.getMessage());
        }

    }
}