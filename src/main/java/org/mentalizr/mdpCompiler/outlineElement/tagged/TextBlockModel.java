package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.ArrayList;
import java.util.List;

public class TextBlockModel extends OutlineElementModel {

    private final List<Line> textBlockLines;

    public TextBlockModel(List<Line> textBlockLines) {
        this.textBlockLines = new ArrayList<>(textBlockLines);
    }

    public int getNrOfTextBlockLines() {
        return this.textBlockLines.size();
    }

    public List<Line> getTextBlockLines() {
        return this.textBlockLines;
    }

    public String getSingleLineAsString() {
        if (getNrOfTextBlockLines() != 1) throw new IllegalStateException("Text block has not a single line. Number of lines: " + getNrOfTextBlockLines());

        return this.textBlockLines.get(0).asString();
    }

    public Document asDocument() {
        return new Document(this.textBlockLines);
    }

}
