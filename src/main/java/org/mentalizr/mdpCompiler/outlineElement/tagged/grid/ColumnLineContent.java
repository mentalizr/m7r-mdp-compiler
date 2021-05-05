package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;

import java.util.ArrayList;
import java.util.List;

public class ColumnLineContent {

    private final String classValue;
    private final List<Line> content;

    public ColumnLineContent(String classValue) {
        this.classValue = classValue;
        this.content = new ArrayList<>();
    }

    public void add(Line lineOfContent) {
        this.content.add(lineOfContent);
    }

    public String getClassValue() {
        return this.classValue;
    }

    public Document asDocument() {
        return new Document(this.content);
    }
}
