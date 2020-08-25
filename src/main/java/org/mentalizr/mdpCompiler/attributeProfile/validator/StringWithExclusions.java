package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

/**
 * A string type validator that requires, that value does not contain one of the
 * given substrings.
 */
public class StringWithExclusions extends StringType implements AttributeValidator {

    private final String[] excludedStrings;

    public StringWithExclusions(String... excludedStrings) {
        this.excludedStrings = excludedStrings;
    }

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {

        super.validate(attribute);

        for (String excludedString : this.excludedStrings) {
            if (attribute.getValue().contains(excludedString)) {
                throw new AttributeValidationException(attribute, "Value contains excluded substring '" + excludedString + "'.");
            }
        }

    }
}
