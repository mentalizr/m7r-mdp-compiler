package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class MCQuestionAttributes extends OutlineElementTaggedAttributes {

    public static final String ID = "id";
    public static final String TYPE = "type";
    public static final String MARGIN_TOP = "margin-top";
    public static final String MARGIN_BOTTOM = "margin-bottom";

    public static final String TYPE_VALUE_ONE = "one";
    public static final String TYPE_VALUE_MULTI = "multi";
    public static final String TYPE_VALUE_AUTO = "auto";

    public MCQuestionAttributes(Attributes attributes) {
        super(attributes);
    }

    public boolean hasId() {
        return this.attributes.hasAttribute(ID);
    }

    public String getId() {
        return this.attributes.getValue(ID);
    }

    public String getType() {
        return this.attributes.getValue(TYPE);
    }

    public String getMarginTop() {
        return this.attributes.getValue(MARGIN_TOP);
    }

    public String getMarginBottom() {
        return this.attributes.getValue(MARGIN_BOTTOM);
    }

}
