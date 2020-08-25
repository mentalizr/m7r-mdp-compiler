package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

public class IntegerRange extends IntegerType implements AttributeValidator {

    protected int min;
    protected int max;

    public IntegerRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {

        super.validate(attribute);

        if (this.valueParsed < min || this.valueParsed > max)
            throw new AttributeValidationException(attribute, "Value out of range.");
    }

}
