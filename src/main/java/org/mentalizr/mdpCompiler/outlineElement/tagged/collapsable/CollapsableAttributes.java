package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class CollapsableAttributes extends OutlineElementTaggedAttributes {

    public static final String ID = "id";
    public static final String SHOW_FIRST = "showFirst";
    public static final String MARGIN_TOP = "margin-top";
    public static final String MARGIN_BOTTOM = "margin-bottom";

    public CollapsableAttributes(Attributes attributes) {
        super(attributes);
    }

    public boolean hasId() {
        return this.attributes.hasAttribute(CollapsableAttributes.ID);
    }

    public String getId() {
        return this.attributes.getValue(CollapsableAttributes.ID);
    }

    public boolean isShowFirst() {
        return this.attributes.hasAttribute(CollapsableAttributes.SHOW_FIRST);
    }

    public String getMarginTop() {
        return this.attributes.getValue(MARGIN_TOP);
    }

    public String getMarginBottom() {
        return this.attributes.getValue(MARGIN_BOTTOM);
    }

}
