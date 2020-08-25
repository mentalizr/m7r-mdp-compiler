package org.mentalizr.mdpCompiler.outlineElement.tagged.html;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class HtmlAttributes extends OutlineElementTaggedAttributes {

    public static final String NAME_ID = "id";
    public static final String NAME_MARGIN_TOP = "margin-top";
    public static final String NAME_MARGIN_BOTTOM = "margin-bottom";

    public HtmlAttributes(Attributes attributes) {
        super(attributes);
    }

    public boolean hasId() {
        return this.attributes.hasAttribute(NAME_ID);
    }

    public String getId() {
        return this.attributes.getValue(NAME_ID);
    }

    public String getMarginTop() {
        return this.attributes.getValue(NAME_MARGIN_TOP);
    }

    public String getMarginBottom() {
        return this.attributes.getValue(NAME_MARGIN_BOTTOM);
    }

}
