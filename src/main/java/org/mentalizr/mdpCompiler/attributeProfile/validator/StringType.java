package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

public class StringType implements AttributeValidator {

    protected String validatedString;

    public StringType() {
        this.validatedString = null;
    }

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {
        this.validatedString = attribute.getValue();
    }

}
