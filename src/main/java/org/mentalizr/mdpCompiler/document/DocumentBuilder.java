package org.mentalizr.mdpCompiler.document;

import java.util.ArrayList;
import java.util.List;

public class DocumentBuilder {

    private int index;
    private final List<Line> lineList;

    public DocumentBuilder(int beginLineIndex) {

        if (beginLineIndex < 0) throw new IllegalArgumentException("Illegal line index: is negative.");

        this.index = beginLineIndex;
        this.lineList = new ArrayList<>();
    }

    public DocumentBuilder add(String lineString) {
        this.lineList.add(new Line(lineString, index));
        this.index++;
        return this;
    }

    public Document build() {
        return new Document(this.lineList);
    }


}
