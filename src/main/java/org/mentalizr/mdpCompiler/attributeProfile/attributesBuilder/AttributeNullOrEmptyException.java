package org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder;

public class AttributeNullOrEmptyException extends AttributesBuilderException {

    public AttributeNullOrEmptyException() {
        super("", "Name of attribute is null or empty.");
    }

}
