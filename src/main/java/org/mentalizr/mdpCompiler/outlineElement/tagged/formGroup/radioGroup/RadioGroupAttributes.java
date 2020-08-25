package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.attributeProfile.Attribute;
import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupAttributes;

import java.util.HashSet;
import java.util.Set;

public class RadioGroupAttributes extends FormGroupAttributes {

    public static final String ATTRIBUTE_NAME_NAME = "name";

    private final Attributes openSimpleAttributes;

    public RadioGroupAttributes(Attributes attributes, Attributes openSimpleAttributes) {
        super(attributes);
        this.openSimpleAttributes = openSimpleAttributes;
    }

    public String getName() {
        return this.attributes.getValue(ATTRIBUTE_NAME_NAME);
    }

    public Set<String> getOpenSimpleAttributes() {
        Set<String> openSimpleAttributesSet = new HashSet<>();

        for (Attribute attribute : this.openSimpleAttributes) {
            openSimpleAttributesSet.add(attribute.getName());
        }

        return openSimpleAttributesSet;
    }

}
