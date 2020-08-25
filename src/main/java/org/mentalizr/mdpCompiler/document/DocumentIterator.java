package org.mentalizr.mdpCompiler.document;

import java.util.Arrays;
import java.util.List;

/**
 * Allows iteration over mdp source file in forward and backward direction.
 * After initializing {@link DocumentIterator} is in a 'pre-state', that means
 * checking for a next line needs to be done.
 *
 */
public class DocumentIterator {

    private final List<Line> lines;
    private int index;

    public DocumentIterator(Document document) {
        this.lines = document.getLines();
        this.index = -1;
    }

    /**
     * Checks whether {@link DocumentIterator} has a next line.
     *
     * @return
     */
    public boolean hasNextLine() {
        return (this.lines.size() - 1 > this.index);
    }

    /**
     * Returns next line and moves iterator one line further.
     *
     * @return
     */
    public Line getNextLine() {
        if (!hasNextLine()) throw new IllegalStateException("Document has no next line.");
        this.index++;
        return this.lines.get(this.index);
    }

    /**
     * Checks whether {@link DocumentIterator} points to a valid line.
     *
     * @return
     */
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

    public Line getPreviousLine() {
        if (!hasPreviousLine()) throw new IllegalStateException("Document has no previous line.");
        this.index--;
        return this.lines.get(this.index);
    }

    public int getIndex() {
        return this.index;
    }

    /**
     * Intended to be used in tests.
     *
     * @param mdpLines
     * @return
     */
    public static DocumentIterator getInstance(String... mdpLines) {
        Document document = new Document(0, Arrays.asList(mdpLines));
        return document.getDocumentIterator();
    }

}
