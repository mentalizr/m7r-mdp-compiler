package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;

import java.util.List;

public abstract class Extraction {

    protected List<Line> lines;

    public Extraction(List<Line> lines) {
        this.lines = Lines.shallowCopy(lines);
    }

    public Extraction(Document document) {
        this.lines = document.getLines();
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public List<Line> getLinesWithoutTagLine() {
        assertNotEmpty();
        return this.lines.subList(1, this.lines.size());
    }

    public boolean isEmpty() {
        return this.lines.isEmpty();
    }

    public int getNrOfLines() {
        return this.lines.size();
    }

    public Line getTagLine() {
        assertNotEmpty();
        return this.lines.get(0);
    }

    public int getTagLineIndex() {
        assertNotEmpty();
        return this.lines.get(0).getLineIndex();
    }

    private void assertNotEmpty() {
        if (isEmpty())
            throw new IllegalStateException("Extraction is empty. Check is required before calling method.");
    }

}
