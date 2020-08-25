package org.mentalizr.mdpCompiler.attributeProfile;

import org.mentalizr.mdpCompiler.attributeProfile.validator.AttributeValidator;

public final class AttributeSpec {

    private final String attributeName;
    private final boolean simple;
    private final boolean required;
    private final boolean noEmptyValue;
    private final String defaultValue;
    private final AttributeValidator attributeValidator;

    public AttributeSpec(String attributeName, boolean simple, boolean required, boolean noEmptyValue, String defaultValue, AttributeValidator attributeValidator) {
        this.attributeName = attributeName;
        this.simple = simple;
        this.required = required;
        this.noEmptyValue = noEmptyValue;
        this.defaultValue = defaultValue;
        this.attributeValidator = attributeValidator;

        if (simple && (noEmptyValue || defaultValue != null || attributeValidator != null))
            throw new IllegalArgumentException("Attribute specified as simple must not have a 'noEmptyValue' flag set, a 'defaultValue' or an 'attributeValidator'.");
    }

    public String getAttributeName() {
        return attributeName;
    }

    public boolean isSimple() {
        return simple;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean noEmptyValue() {
        return noEmptyValue;
    }

    public boolean hasDefaultValue() {
        return this.defaultValue != null;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public boolean hasAttributeValidator() {
        return this.attributeValidator != null;
    }

    public AttributeValidator getAttributeValidator() {
        return attributeValidator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeSpec that = (AttributeSpec) o;
        return attributeName.equals(that.attributeName);
    }

    @Override
    public int hashCode() {
        return this.attributeName.hashCode();
    }
}
