package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class VideoAttributes extends OutlineElementTaggedAttributes {

    public static final String NAME_POSTER = "poster";
    public static final String NAME_MARGIN_TOP = "margin-top";
    public static final String NAME_MARGIN_BOTTOM = "margin-bottom";

    public VideoAttributes(Attributes attributes) {
        super(attributes);
    }

    public boolean hasPoster() {
        return this.attributes.hasAttribute(NAME_POSTER);
    }

    public String getPoster() {
        return this.attributes.getValue(NAME_POSTER);
    }

    public String getMarginTop() {
        return this.attributes.getValue(NAME_MARGIN_TOP);
    }

    public String getMarginBottom() {
        return this.attributes.getValue(NAME_MARGIN_BOTTOM);
    }

}
