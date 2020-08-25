package org.mentalizr.mdpCompiler.attributeProfile;

import org.mentalizr.mdpCompiler.attributeProfile.validator.AttributeValidator;

public class AttributeSpecBuilder {

    private final String attributeName;
    private boolean simple;
    private boolean required;
    private boolean noEmptyValue;
    private String defaultValue;
    private AttributeValidator attributeValidator;

    public AttributeSpecBuilder(String attributeName) {
        this.attributeName = attributeName;
        this.simple = false;
        this.required = false;
        this.noEmptyValue = false;
        this.defaultValue = null;
        this.attributeValidator = null;
    }

    public AttributeSpecBuilder isSimple() {
        this.simple = true;
        return this;
    }

    public AttributeSpecBuilder isRequired() {
        this.required = true;
        return this;
    }

    public AttributeSpecBuilder withNoEmptyValue() {
        this.noEmptyValue = true;
        return this;
    }

    public AttributeSpecBuilder withDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public AttributeSpecBuilder withValidator(AttributeValidator attributeValidator) {
        this.attributeValidator = attributeValidator;
        return this;
    }

    public AttributeSpec build() {
        return new AttributeSpec(this.attributeName, this.simple, this.required, this.noEmptyValue, this.defaultValue, this.attributeValidator);
    }

}
