package org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder;

import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.Attributes;

import java.util.HashMap;
import java.util.Map;

public class AttributesBuilder {

    private final Map<String, Attribute> attributes;

    public AttributesBuilder() {
        this.attributes = new HashMap<>();
    }

    public AttributesBuilder addAttribute(String name, String value) throws AttributeProfileException {

        assertNameIsHealthy(name);
        assertAttributeNotYetDefined(name);

        Attribute attribute = new Attribute(name, value);
        this.attributes.put(name, attribute);

        return this;
    }

    public AttributesBuilder addSimpleAttribute(String name) throws AttributeProfileException {

        assertNameIsHealthy(name);
        assertAttributeNotYetDefined(name);

        Attribute attribute = new Attribute(name, null);
        this.attributes.put(name, attribute);

        return this;
    }

    public AttributesBuilder addAttribute(Attribute attribute) throws AttributeProfileException {

        assertNameIsHealthy(attribute.getName());
        assertAttributeNotYetDefined(attribute.getName());

        this.attributes.put(attribute.getName(), attribute);

        return this;
    }

    public Attributes build() {
        return new Attributes(this.attributes);
    }

    private void assertNameIsHealthy(String name) throws AttributeProfileException {
        if (Strings.isNullOrEmpty(name))
            throw new AttributeNullOrEmptyException();
    }

    private void assertAttributeNotYetDefined(String name) throws AttributeProfileException {
        if (this.attributes.containsKey(name))
            throw new AttributeAlreadySpecifiedException(name);
    }

}
