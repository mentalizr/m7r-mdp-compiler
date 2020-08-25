package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerRangeTest {

    @Test
    void lowerBorder() {

        IntegerRange integerRange = new IntegerRange(2, 10);
        Attribute attribute = new Attribute("name", "2");

        try {
            integerRange.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

    @Test
    void plausibility() {

        IntegerRange integerRange = new IntegerRange(2, 10);
        Attribute attribute = new Attribute("name", "5");

        try {
            integerRange.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

    @Test
    void upperBorder() {

        IntegerRange integerRange = new IntegerRange(2, 10);
        Attribute attribute = new Attribute("name", "10");

        try {
            integerRange.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

    @Test
    void belowLimit() {

        IntegerRange integerRange = new IntegerRange(2, 10);
        Attribute attribute = new Attribute("name", "1");

        try {
            integerRange.validate(attribute);
            fail("exception expected");
        } catch (AttributeValidationException e) {
            // din
        }
    }

    @Test
    void limitExceeded() {

        IntegerRange integerRange = new IntegerRange(2, 10);
        Attribute attribute = new Attribute("name", "100");

        try {
            integerRange.validate(attribute);
            fail("exception expected");
        } catch (AttributeValidationException e) {
            // din
        }
    }

    @Test
    void plausibility_negative() {

        IntegerRange integerRange = new IntegerRange(2, 10);
        Attribute attribute = new Attribute("name", "dummy");

        try {
            integerRange.validate(attribute);
            fail("exception expected");
        } catch (AttributeValidationException e) {
            // din
        }
    }


}