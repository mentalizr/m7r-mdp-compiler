package org.mentalizr.mdpCompiler.document;


import org.mentalizr.mdpCompiler.helper.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Document implements Iterable<Line> {

    private List<Line> lines;

    public Document(List<Line> lines) {
        sanityCheck(lines);
        this.lines = lines;
    }

    public Document(int beginLineIndex, List<String> lineStringList) {
        initialize(beginLineIndex, lineStringList);
    }

    public Document(String... lineStrings) {
        List<String> lineStringList = new ArrayList<>(Arrays.asList(lineStrings));
        initialize(0, lineStringList);
    }

    public Document(File mdpFile) throws IOException {
        List<String> lineStringList = TextFile.getLinesAsStrings(mdpFile);
        initialize(0, lineStringList);
    }

    private void initialize(int beginLineIndex, List<String> lineStringList) {
        this.lines = new ArrayList<>();
        int index = beginLineIndex;
        for (String lineString : lineStringList) {
            lines.add(new Line(lineString, index));
            index++;
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public DocumentIterator getDocumentIterator() {
        return new DocumentIterator(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return lines.equals(document.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public Iterator<Line> iterator() {
        return this.lines.iterator();
    }

    private void sanityCheck(List<Line> lines) {
        int index = -1;
        for (Line line : lines) {
            if (index < 0) {
                index = line.getLineIndex();
            } else {
                if (line.getLineIndex() != index +1) throw new IllegalArgumentException("Inconsistent line index when initializing document.");
                index = line.getLineIndex();
            }
        }
    }

}
