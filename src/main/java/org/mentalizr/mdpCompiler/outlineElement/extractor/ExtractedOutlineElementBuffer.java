package org.mentalizr.mdpCompiler.outlineElement.extractor;

import org.mentalizr.mdpCompiler.document.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtractedOutlineElementBuffer {

    private List<Line> extractedLines;

    public ExtractedOutlineElementBuffer() {
        this.extractedLines = new ArrayList<>();
    }

    public void add(Line line) {
        this.extractedLines.add(line);
    }

    public boolean hasBlankLine() {
        for (Line line : extractedLines) {
            if (line.asString().isBlank()) return true;
        }
        return false;
    }

    public int getNrOfLines() {
        return this.extractedLines.size();
    }

    public List<Line> getLines() {
        return this.extractedLines;
    }

    public void stripTrailingEmptyLines() {

        List<Line> validLines = new ArrayList<>();
        boolean isTrailing = true;

        for (int i = this.extractedLines.size() - 1; i >= 0; i--) {
            Line line = this.extractedLines.get(i);
            if (isTrailing) {
                if (!line.asString().isBlank()) {
                    validLines.add(line);
                    isTrailing = false;
                }
            } else {
                validLines.add(line);
            }
        }

        Collections.reverse(validLines);
        this.extractedLines = validLines;
    }

}
