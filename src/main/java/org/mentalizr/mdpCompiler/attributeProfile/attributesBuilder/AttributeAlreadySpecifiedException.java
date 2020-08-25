package org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder;

public class AttributeAlreadySpecifiedException extends AttributesBuilderException {

    public AttributeAlreadySpecifiedException(String attributeName) {
        super(attributeName, "Attribute with same name is already specified: " + attributeName + ".");
    }
}
