package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

import java.math.BigDecimal;

public class PositiveDecimal extends DecimalType implements AttributeValidator {

    public PositiveDecimal() {
    }

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {

        super.validate(attribute);

        if (this.valueParsed.compareTo(new BigDecimal(0)) <= 0)
            throw new AttributeValidationException(attribute, "Value not positive.");
    }

}
