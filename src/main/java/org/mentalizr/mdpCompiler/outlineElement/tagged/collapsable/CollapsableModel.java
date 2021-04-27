package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.ArrayList;
import java.util.List;

public class CollapsableModel extends OutlineElementTaggedModel {

    private final List<CollapsableCardContent> collapsableCardContentList;

    public CollapsableModel(OutlineElement outlineElement, MDPTag mdpTag) {
        super(outlineElement);
        setMdpTag(mdpTag);
        this.collapsableCardContentList = new ArrayList<>();
    }

    public void addCardContent(CollapsableCardContent collapsableCardContent) {
        this.collapsableCardContentList.add(collapsableCardContent);
    }

    public List<CollapsableCardContent> getCollapsableCardContentList() {
        return this.collapsableCardContentList;
    }

    public int getIndex(CollapsableCardContent collapsableCardContent) {
        int index = this.collapsableCardContentList.indexOf(collapsableCardContent);
        if (index < 0) throw new IllegalStateException("Could not find element in list.");
        return index;
    }

    public CollapsableAttributes getCollapsableAttributes() {
        return (CollapsableAttributes) this.mdpTag.getAttributes();
    }

}
