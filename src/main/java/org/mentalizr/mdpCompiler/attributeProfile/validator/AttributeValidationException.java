package org.mentalizr.mdpCompiler.attributeProfile.validator;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;

public class AttributeValidationException extends AttributeProfileException {

    private final String attributeValue;

    public AttributeValidationException(String attributeName, String attributeValue, String message) {
        super(attributeName, message + " ["+ attributeName + "=\"" + attributeValue + "\"]");
        this.attributeValue = attributeValue;
    }

    public AttributeValidationException(Attribute attribute, String message) {
        super(attribute.getName(), message + " ["+ attribute.getName() + "=\"" + attribute.getValue() + "\"]");
        this.attributeValue = attribute.getValue();
    }

    public String getAttributeValue() {
        return attributeValue;
    }
}
