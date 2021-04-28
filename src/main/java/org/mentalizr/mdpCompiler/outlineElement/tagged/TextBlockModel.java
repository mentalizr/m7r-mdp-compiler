package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.List;

public class TextBlockModel extends OutlineElementTaggedModel {

    private List<Line> textBlockLines;

    public TextBlockModel(OutlineElement outlineElement) {
        super(outlineElement);
    }

    public void setTextBlockLines(List<Line> textBlockLines) {
        this.textBlockLines = textBlockLines;
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

    public OutlineElementTaggedAttributes getOutlineElementTaggedAttributes() {
        return this.mdpTag.getAttributes();
    }

    public Document asDocument() {
        return new Document(this.textBlockLines);
    }

}
