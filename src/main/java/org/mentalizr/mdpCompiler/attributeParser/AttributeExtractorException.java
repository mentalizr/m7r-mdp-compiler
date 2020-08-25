package org.mentalizr.mdpCompiler.attributeParser;

import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;

public abstract class AttributeExtractorException extends AttributeProfileException {

    public AttributeExtractorException(String attributeName, String message) {
        super(attributeName, message);
    }
}
