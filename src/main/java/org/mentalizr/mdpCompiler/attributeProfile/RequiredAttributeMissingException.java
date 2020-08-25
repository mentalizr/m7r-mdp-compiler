package org.mentalizr.mdpCompiler.attributeProfile;

public class RequiredAttributeMissingException extends AttributeProfileException {

    public RequiredAttributeMissingException(String attributeName) {
        super(attributeName, "Missing required attribute '" + attributeName + "'.");
    }
}
