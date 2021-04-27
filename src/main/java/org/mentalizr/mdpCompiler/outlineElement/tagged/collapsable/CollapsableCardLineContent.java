package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;

import java.util.ArrayList;
import java.util.List;

public class CollapsableCardLineContent {

    private final int index;
    private final String header;
    private final List<Line> content;

    public CollapsableCardLineContent(int index, String header) {
        this.index = index;
        this.header = header;
        this.content = new ArrayList<>();
    }

    public void add(Line lineOfCardContent) {
        this.content.add(lineOfCardContent);
    }

    public int getIndex() {
        return this.index;
    }

    public String getHeader() {
        return this.header;
    }

    public List<Line> getContent() {
        return this.content;
    }

    public int getNrOfContentLines() {
        return this.content.size();
    }

    public boolean hasSingleLine() {
        return this.content.size() == 1;
    }

    public String getSingleLine() {
        if (this.content.isEmpty()) throw new IllegalStateException("Has no content. Check before calling method.");
        return this.content.get(0).asString();
    }

    public Document getContentAsDocument() {
        return new Document(this.content);
    }
}
