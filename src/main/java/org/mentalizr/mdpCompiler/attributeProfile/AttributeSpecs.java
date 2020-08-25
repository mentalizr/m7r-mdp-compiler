package org.mentalizr.mdpCompiler.attributeProfile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AttributeSpecs {

    private Map<String, AttributeSpec> attributeSpecMap;
    private final boolean allowOpenSimpleAttributes;

    public AttributeSpecs(Set<AttributeSpec> attributeSpecSet) {
        init(attributeSpecSet);
        this.allowOpenSimpleAttributes = false;
    }

    public AttributeSpecs(Set<AttributeSpec> attributeSpecSet, boolean allowOpenSimpleAttributes) {
        init(attributeSpecSet);
        this.allowOpenSimpleAttributes = allowOpenSimpleAttributes;
    }

    private void init(Set<AttributeSpec> attributeSpecSet) {
        this.attributeSpecMap = new HashMap<>();
        for (AttributeSpec attributeSpec : attributeSpecSet) {
            this.attributeSpecMap.put(attributeSpec.getAttributeName(), attributeSpec);
        }
    }

    /**
     * Returns the names of all attributes specified as required.
     *
     * @return
     */
    public Set<String> getNamesOfRequired() {
        Set<String> requiredAttributes = new HashSet<>();
        for (String attribute : this.attributeSpecMap.keySet()) {
            AttributeSpec attributeSpec = this.attributeSpecMap.get(attribute);
            if (attributeSpec.isRequired()) requiredAttributes.add(attribute);
        }
        return requiredAttributes;
    }

    /**
     * Returns the names of attributes, for which requirement specifications are done,
     * but not contained in given attributes.
     *
     * @param attributes
     * @return
     */
    public Set<String> getNamesOfNotSetAttributes(Attributes attributes) {
        Set<String> notSpecifiedAttributes = new HashSet<>();
        for (String attributeName : this.attributeSpecMap.keySet()) {
            if (!attributes.hasAttribute(attributeName)) notSpecifiedAttributes.add(attributeName);
        }
        return notSpecifiedAttributes;
    }

    public boolean hasAttributeSpec(String name) {
        return this.attributeSpecMap.containsKey(name);
    }

    public AttributeSpec getAttributeSpec(String name) {
        if (!this.attributeSpecMap.containsKey(name))
            throw new IllegalArgumentException("No " + AttributeSpec.class.getSimpleName() + " found for attribute '" + name + "'.");

        return this.attributeSpecMap.get(name);
    }

    public boolean isAllowOpenSimpleAttributes() {
        return this.allowOpenSimpleAttributes;
    }

}
