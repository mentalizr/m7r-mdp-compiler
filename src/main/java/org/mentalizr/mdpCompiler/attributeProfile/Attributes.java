package org.mentalizr.mdpCompiler.attributeProfile;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;

import java.util.*;

public final class Attributes implements Iterable<Attribute> {

    private final Map<String, Attribute> attributes;

    public Attributes(Map<String, Attribute> attributes) {
        AssertMethodPrecondition.parameterNotNull("attributes", attributes);
        this.attributes = new HashMap<>(attributes);
    }

    public Set<String> getAttributeNameSet() {
        return this.attributes.keySet();
    }

    public boolean hasAttribute(String attributeName) {
        return this.attributes.containsKey(attributeName);
    }

    public Attribute getAttribute(String name) {
        assertAttributeNameExists(name);
        return this.attributes.get(name);
    }

    /**
     * Returns the value of the specified attribute name, null if attribute has no assignment (is simple).
     *
     * @throws IllegalArgumentException if attribute with specified name is not existing
     */
    public String getValue(String name) {
        assertAttributeNameExists(name);
        return this.attributes.get(name).getValue();
    }

    public int getNrOfAttributes() {
        return this.attributes.size();
    }

    @Override
    public Iterator<Attribute> iterator() {
        ArrayList<Attribute> attributeList = new ArrayList<>(this.attributes.values());
        return attributeList.iterator();
    }

    private void assertAttributeNameExists(String attributeName) {
        if (!this.attributes.containsKey(attributeName))
            throw new IllegalArgumentException("Specified attributeName not known: '" + attributeName + "'");
    }

}
