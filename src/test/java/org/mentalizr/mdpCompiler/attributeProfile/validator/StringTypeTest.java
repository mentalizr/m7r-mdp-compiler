package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTypeTest {

    @Test
    void plausibility_positive() {
        StringType stringType = new StringType();
        Attribute attribute = new Attribute("name", "value");

        try {
            stringType.validate(attribute);
        } catch (AttributeValidationException e) {
            fail(e);
        }
    }

}