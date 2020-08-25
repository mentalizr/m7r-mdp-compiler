package org.mentalizr.mdpCompiler.attributeProfile;

public class IllegalAttributeException extends AttributeProfileException {

    public IllegalAttributeException(String attributeName) {
        super(attributeName, "Illegal attribute: '" + attributeName + "'.");
    }
}
