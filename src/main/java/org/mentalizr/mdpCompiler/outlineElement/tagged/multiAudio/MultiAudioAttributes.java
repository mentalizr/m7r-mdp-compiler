package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

public class MultiAudioAttributes extends OutlineElementTaggedAttributes {

    public static final String ID = "id";
    public static final String NAME_MARGIN_TOP = "margin-top";
    public static final String NAME_MARGIN_BOTTOM = "margin-bottom";

    public MultiAudioAttributes(Attributes attributes) {
        super(attributes);
    }

    public boolean hasId() {
        return this.attributes.hasAttribute(ID);
    }

    public String getId() {
        return this.attributes.getValue(ID);
    }

    public String getMarginTop() {
        return this.attributes.getValue(NAME_MARGIN_TOP);
    }

    public String getMarginBottom() {
        return this.attributes.getValue(NAME_MARGIN_BOTTOM);
    }

}
