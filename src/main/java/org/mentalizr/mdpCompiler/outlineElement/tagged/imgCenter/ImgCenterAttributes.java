package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class ImgCenterAttributes extends OutlineElementTaggedAttributes {

    public static final String NAME_ALT = "alt";
    public static final String NAME_MARGIN_TOP = "margin-top";
    public static final String NAME_MARGIN_BOTTOM = "margin-bottom";

    public ImgCenterAttributes(Attributes attributes) {
        super(attributes);
    }

    public String getAlt() {
        return this.attributes.getValue(NAME_ALT);
    }

//    public boolean hasMarginTop() {
//        return this.attributes.hasAttribute(NAME_MARGIN_TOP);
//    }

    public String getMarginTop() {
        return this.attributes.getValue(NAME_MARGIN_TOP);
    }

//    public boolean hasMarginBottom() {
//        return this.attributes.hasAttribute(NAME_MARGIN_BOTTOM);
//    }

    public String getNameMarginBottom() {
        return this.attributes.getValue(NAME_MARGIN_BOTTOM);
    }

}
