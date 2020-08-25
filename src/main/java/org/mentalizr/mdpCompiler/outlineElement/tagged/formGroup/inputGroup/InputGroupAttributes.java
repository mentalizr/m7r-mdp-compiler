package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupAttributes;

public class InputGroupAttributes extends FormGroupAttributes {

    public static final String ATTRIBUTE_NAME_INPUTTYPE = "inputtype";
    public static final String ATTRIBUTE_NAME_PLACEHOLDER = "placeholder";
    public static final String VALUE_TEXT = "text";
    public static final String VALUE_TIME = "time";
    public static final String VALUE_DATE = "date";

    public InputGroupAttributes(Attributes attributes) {
        super(attributes);
    }

    public String getInputtype() {
        return this.attributes.getValue(InputGroupAttributes.ATTRIBUTE_NAME_INPUTTYPE);
    }

    public boolean hasPlaceholder() {
        return this.attributes.hasAttribute(InputGroupAttributes.ATTRIBUTE_NAME_PLACEHOLDER);
    }

    public String getPlaceholder() {
        return this.attributes.getValue(InputGroupAttributes.ATTRIBUTE_NAME_PLACEHOLDER);
    }

}
