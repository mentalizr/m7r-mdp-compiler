package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.List;

public class CollapsableCardContent {

    private final int index;
    private final String header;
    private final List<OutlineElementModel> childElements;
    private final String singleLine;

    public CollapsableCardContent(int index, String header, List<OutlineElementModel> childElements) {
        this.index = index;
        this.header = header;
        this.childElements = childElements;
        this.singleLine = null;
    }

    public CollapsableCardContent(int index, String header, String singleLine) {
        this.index = index;
        this.header = header;
        this.childElements = null;
        this.singleLine = singleLine;
    }

//    public int getIndex() {
//        return this.index;
//    }

    public String getHeader() {
        return this.header;
    }

    public List<OutlineElementModel> getChildElements() {
        return this.childElements;
    }

    public String getSingleLine() {
        return this.singleLine;
    }

    public boolean hasSingleLine() {
        return this.singleLine != null;
    }

    public boolean hasChildElements() {
        return this.childElements != null;
    }
}
