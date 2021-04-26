package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.ArrayList;
import java.util.List;

public class CollapsableModel extends OutlineElementTaggedModel {

    private final List<CollapsableCardContent> collapsableCardContentList;
    private CollapsableCardContent curCollapsableCardContent;

    public CollapsableModel(OutlineElement outlineElement) {
        super(outlineElement);
        this.collapsableCardContentList = new ArrayList<>();
        this.curCollapsableCardContent = null;
    }

    public void createNextCard(String header) {
        this.curCollapsableCardContent = new CollapsableCardContent(this.collapsableCardContentList.size(), header);
        this.collapsableCardContentList.add(this.curCollapsableCardContent);
    }

    public void addContentLine(Line lineOfCardContent) {
        this.curCollapsableCardContent.add(lineOfCardContent);
    }

    public List<CollapsableCardContent> getCollapsableCardContentList() {
        return collapsableCardContentList;
    }

    public boolean hasCurCard() {
        return this.curCollapsableCardContent != null;
    }

    public CollapsableAttributes getCollapsableAttributes() {
        return (CollapsableAttributes) this.mdpTag.getAttributes();
    }

}
