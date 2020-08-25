package org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder;

import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;

public abstract class AttributesBuilderException extends AttributeProfileException {

    public AttributesBuilderException(String attributeName, String message) {
        super(attributeName, message);
    }

}
