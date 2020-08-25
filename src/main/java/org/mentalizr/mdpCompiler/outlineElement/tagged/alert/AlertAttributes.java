package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class AlertAttributes extends OutlineElementTaggedAttributes {

    public static final String ATTRIBUTE_NAME_TYPE = "type";
    public static final String ATTRIBUTE_NAME_HEADERSIZE = "headersize";
    public static final String VALUE_INFO = "info";
    public static final String VALUE_EXERCISE = "exercise";

    public AlertAttributes(Attributes attributes) {
        super(attributes);
    }

    public String getType() {
        return this.attributes.getValue(AlertAttributes.ATTRIBUTE_NAME_TYPE);
    }

    public String getBootstrapAlertType() {
        String bootstrapAlertType = "info";
        if (getType().equals(AlertAttributes.VALUE_EXERCISE)) {
            bootstrapAlertType = "danger";
        }
        return bootstrapAlertType;
    }

    public boolean hasHeadersize() {
        return this.attributes.hasAttribute(AlertAttributes.ATTRIBUTE_NAME_HEADERSIZE);
    }

    public String getHeadersize() {
        return this.attributes.getValue(AlertAttributes.ATTRIBUTE_NAME_HEADERSIZE);
    }

}
