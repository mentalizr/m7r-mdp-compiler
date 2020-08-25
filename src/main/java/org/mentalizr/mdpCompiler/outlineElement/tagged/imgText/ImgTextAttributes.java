package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class ImgTextAttributes extends OutlineElementTaggedAttributes {

    public static final String NAME_ALT = "alt";
    public static final String NAME_IMG_COL_WIDTH = "img-col-width";
    public static final String NAME_IMG_EXPAND = "img-expand";
    public static final String NAME_MARGIN_TOP = "margin-top";
    public static final String NAME_MARGIN_BOTTOM = "margin-bottom";

    public ImgTextAttributes(Attributes attributes) {
        super(attributes);
    }

    public String getAlt() {
        return this.attributes.getValue(NAME_ALT);
    }

    public Integer getImgColWidth() {
        return Integer.parseInt(this.attributes.getValue(NAME_IMG_COL_WIDTH));
    }

    public boolean isImgExpand() {
        return this.attributes.getValue(NAME_IMG_EXPAND).equals("true");
    }

    public Double getMarginTop() {
        return Double.parseDouble(this.attributes.getValue(NAME_MARGIN_TOP));
    }

    public Double getMarginBootom() {
        return Double.parseDouble(this.attributes.getValue(NAME_MARGIN_BOTTOM));
    }
}
