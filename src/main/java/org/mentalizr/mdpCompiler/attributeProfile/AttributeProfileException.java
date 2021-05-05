package org.mentalizr.mdpCompiler.attributeProfile;

public class AttributeProfileException extends Exception {

    protected String attributeName;

    public AttributeProfileException(String attributeName, String message) {
        super(message);
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

}
