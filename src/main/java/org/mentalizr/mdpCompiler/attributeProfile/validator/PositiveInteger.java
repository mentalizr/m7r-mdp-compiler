package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

public class PositiveInteger extends IntegerType implements AttributeValidator {

    public PositiveInteger() {
    }

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {

        super.validate(attribute);

        if (this.valueParsed <= 0)
            throw new AttributeValidationException(attribute, "Value not positive.");

    }

}
