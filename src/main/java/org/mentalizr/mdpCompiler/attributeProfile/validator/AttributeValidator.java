package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

public interface AttributeValidator {

    void validate(Attribute attribute) throws AttributeValidationException;

}
