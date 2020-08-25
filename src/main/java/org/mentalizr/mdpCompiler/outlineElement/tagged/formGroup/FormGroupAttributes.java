package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public abstract class FormGroupAttributes extends OutlineElementTaggedAttributes {

    public static final String ATTRIBUTE_NAME_ID = "id";
    public static final String ATTRIBUTE_NAME_REF_ID = "ref-id";
    public static final String ATTRIBUTE_NAME_SCOPE = "scope";
    public static final String ATTRIBUTE_NAME_SCOPE_ID = "scope-id";
    public static final String ATTRIBUTE_NAME_READONLY = "readonly";
    public static final String VALUE_PROGRAM = "program";
    public static final String VALUE_PAGE = "page";
    public static final String VALUE_GENERIC = "generic";

    public FormGroupAttributes(Attributes attributes) {
        super(attributes);
    }

    public String getId() {
        return this.attributes.getValue(ATTRIBUTE_NAME_ID);
    }

    public boolean hasRefId() {
        return this.attributes.hasAttribute(ATTRIBUTE_NAME_REF_ID);
    }

    public String getRefId() {
        return this.attributes.getValue(ATTRIBUTE_NAME_REF_ID);
    }

    public String getScope() {
        return this.attributes.getValue(ATTRIBUTE_NAME_SCOPE);
    }

    public String getScopeId() {
        return this.attributes.getValue(ATTRIBUTE_NAME_SCOPE_ID);
    }

    public boolean isReadonly() {
        return Boolean.parseBoolean(this.attributes.getValue(ATTRIBUTE_NAME_READONLY));
    }


}
