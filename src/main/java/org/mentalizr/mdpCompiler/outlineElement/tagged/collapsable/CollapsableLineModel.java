package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.ArrayList;
import java.util.List;

public class CollapsableLineModel {

    private final List<CollapsableCardLineContent> collapsableCardContentList;
    private CollapsableCardLineContent curCollapsableCardContent;

    public CollapsableLineModel() {
        this.collapsableCardContentList = new ArrayList<>();
        this.curCollapsableCardContent = null;
    }

    public void createNextCard(String header) {
        this.curCollapsableCardContent = new CollapsableCardLineContent(this.collapsableCardContentList.size(), header);
        this.collapsableCardContentList.add(this.curCollapsableCardContent);
    }

    public void addContentLine(Line lineOfCardContent) {
        this.curCollapsableCardContent.add(lineOfCardContent);
    }

    public List<CollapsableCardLineContent> getCollapsableCardContentList() {
        return collapsableCardContentList;
    }

    public boolean hasCurCard() {
        return this.curCollapsableCardContent != null;
    }

//    public CollapsableAttributes getCollapsableAttributes() {
//        return (CollapsableAttributes) this.mdpTag.getAttributes();
//    }

}
