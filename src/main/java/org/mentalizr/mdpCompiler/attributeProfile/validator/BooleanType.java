package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

public class BooleanType implements AttributeValidator {

    protected boolean valueParsed;

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {

        if (attribute.isSimpleAttribute()) throw new IllegalArgumentException("Simple attribute.");

        if (!attribute.getValue().equals("true") && !attribute.getValue().equals("false"))
            throw new AttributeValidationException(attribute, "Not of type boolean.");

        this.valueParsed = java.lang.Boolean.parseBoolean(attribute.getValue());
    }

}
