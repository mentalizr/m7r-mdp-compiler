package org.mentalizr.mdpCompiler.attributeProfile;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;

import java.util.Objects;

public class Attribute {

    private final String name;
    private final String value;

    public Attribute(String name, String value) {

        AssertMethodPrecondition.parameterNotNullAndNotEmpty("name", name);

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean isSimpleAttribute() {
        return this.value == null;
    }

    public boolean hasEmptyValue() {
        if (this.value == null) throw new IllegalStateException("Illegal check for an empty value. Attribute is simple.");
        return (this.value.isEmpty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return name.equals(attribute.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
