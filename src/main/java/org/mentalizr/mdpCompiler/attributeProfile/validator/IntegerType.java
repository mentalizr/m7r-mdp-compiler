package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

public class IntegerType implements AttributeValidator {

    protected int valueParsed;

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {

        try {
            this.valueParsed = java.lang.Integer.parseInt(attribute.getValue());
        } catch (NumberFormatException e) {
            throw new AttributeValidationException(attribute, "Not of type integer.");
        }
    }

}
