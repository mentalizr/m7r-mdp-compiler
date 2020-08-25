package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupAttributes;

public class TextareaGroupAttributes extends FormGroupAttributes {

    public static final String ATTRIBUTE_NAME_ROWS = "rows";

    public TextareaGroupAttributes(Attributes attributes) {
        super(attributes);
    }

    public String getRows() {
        return this.attributes.getValue(ATTRIBUTE_NAME_ROWS);
    }

}
