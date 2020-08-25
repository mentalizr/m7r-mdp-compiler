package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class CardAttributes extends OutlineElementTaggedAttributes {

    public static final String NAME_MARGIN_TOP = "margin-top";
    public static final String NAME_MARGIN_BOTTOM = "margin-bottom";
    public static final String ATTRIBUTE_NAME_HEADER = "header";
    public static final String ATTRIBUTE_NAME_BG_COLOR = "bg-color";
    public static final String ATTRIBUTE_NAME_TEXT_COLOR = "text-color";

    public CardAttributes(Attributes attributes) {
        super(attributes);
    }

    public String getMarginTop() {
        return this.attributes.getValue(NAME_MARGIN_TOP);
    }

    public String getMarginBottom() {
        return this.attributes.getValue(NAME_MARGIN_BOTTOM);
    }

    public boolean hasHeader() {
        return this.attributes.hasAttribute(ATTRIBUTE_NAME_HEADER);
    }

    public String getHeader() {
        return this.attributes.getValue(ATTRIBUTE_NAME_HEADER);
    }

    public boolean hasBgColor() {
        return this.attributes.hasAttribute(ATTRIBUTE_NAME_BG_COLOR);
    }

    public String getBgColor() {
        return this.attributes.getValue(ATTRIBUTE_NAME_BG_COLOR);
    }

    public boolean hasTextColor() {
        return this.attributes.hasAttribute(ATTRIBUTE_NAME_TEXT_COLOR);
    }

    public String getTextColor() {
        return this.attributes.getValue(ATTRIBUTE_NAME_TEXT_COLOR);
    }

}
