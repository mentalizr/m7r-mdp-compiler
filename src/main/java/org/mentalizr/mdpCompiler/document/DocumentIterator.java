package org.mentalizr.mdpCompiler.document;

import java.util.Arrays;
import java.util.List;

public class DocumentIterator {

    private final List<Line> lines;
    private int index;

    public DocumentIterator(Document document) {
        this.lines = document.getLines();
        this.index = -1;
    }

    public boolean hasNextLine() {
        return (this.lines.size() - 1 > this.index);
    }

    public Line getNextLine() {
        if (!hasNextLine()) throw new IllegalStateException("Document has no next line.");
        this.index++;
        return this.lines.get(this.index);
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean hasCurrentLine() {
        return (this.index >= 0 && !this.lines.isEmpty());
    }

    public Line getCurrentLine() {
        if (!hasCurrentLine()) throw new IllegalStateException("Document has no current line.");
        return this.lines.get(this.index);
    }

    public boolean hasPreviousLine() {
        return (this.index >= 1);
    }

    public void stepBack() {
        if (!hasPreviousLine()) throw new IllegalStateException("Document has no previous line.");
        this.index--;
    }

    public int getIndex() {
        return this.index;
    }

    public static DocumentIterator getInstance(String... mdpLines) {
        Document document = new Document(0, Arrays.asList(mdpLines));
        return document.getDocumentIterator();
    }

    public static DocumentIterator getInstanceWithIndexOnFirstLine(String... mdpLines) {
        if (mdpLines.length == 0) throw new RuntimeException("No first line.");
        Document document = new Document(0, Arrays.asList(mdpLines));
        DocumentIterator documentIterator = document.getDocumentIterator();
        documentIterator.getNextLine();
        return documentIterator;
    }

}
