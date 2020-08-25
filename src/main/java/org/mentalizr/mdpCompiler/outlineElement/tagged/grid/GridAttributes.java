package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class GridAttributes extends OutlineElementTaggedAttributes {

    public static final String ATTRIBUTE_NAME_ID = "id";
    public static final String NAME_MARGIN_TOP = "margin-top";
    public static final String NAME_MARGIN_BOTTOM = "margin-bottom";

    public GridAttributes(Attributes attributes) {
        super(attributes);
    }

    public boolean hasId() {
        return this.attributes.hasAttribute(GridAttributes.ATTRIBUTE_NAME_ID);
    }

    public String getId() {
        return this.attributes.getValue(GridAttributes.ATTRIBUTE_NAME_ID);
    }

    public String getMarginTop() {
        return this.attributes.getValue(NAME_MARGIN_TOP);
    }

    public String getMarginBottom() {
        return this.attributes.getValue(NAME_MARGIN_BOTTOM);
    }

}
