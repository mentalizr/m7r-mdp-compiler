package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

import java.math.BigDecimal;

public class DecimalType implements AttributeValidator {

    protected BigDecimal valueParsed;

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {
        try {
            this.valueParsed = new BigDecimal(attribute.getValue());
        } catch (NumberFormatException e) {
            throw new AttributeValidationException(attribute, "Not of type decimal.");
        }
    }
}
