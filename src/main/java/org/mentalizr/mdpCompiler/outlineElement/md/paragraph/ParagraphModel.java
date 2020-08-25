package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.ArrayList;
import java.util.List;

public class ParagraphModel implements OutlineElementModel {

    private final List<String> textLines;

    public ParagraphModel() {
        this.textLines = new ArrayList<>();
    }

    public void addLine(String line) {
        this.textLines.add(line);
    }

    public List<String> getTextLines() {
        return this.textLines;
    }

    public String[] getLinesAsStringArray() {
        return this.textLines.toArray(new String[0]);
    }

}
