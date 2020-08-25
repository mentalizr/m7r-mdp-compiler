package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A string type validator that requires, that value does not contain one of the
 * given substrings.
 */
public class HtmlIdValidator extends StringType implements AttributeValidator {

    private static final Pattern pattern = Pattern.compile("^[a-zA-z][a-zA-Z0-9-_]*");

    public HtmlIdValidator() {
    }

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {

        super.validate(attribute);

        Matcher matcher = pattern.matcher(attribute.getValue());
        if (!matcher.matches()) throw new AttributeValidationException(attribute, "Value is not a valid HTML ID.");

    }
}
