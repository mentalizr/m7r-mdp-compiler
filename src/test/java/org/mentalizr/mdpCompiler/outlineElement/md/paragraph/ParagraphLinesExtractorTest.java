package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParagraphLinesExtractorTest {

    @Test
    @DisplayName("plausibility positive 1")
    void plausibility_pos_1() {

        DocumentIterator documentIterator = DocumentIterator.getInstance("first line", "second line", "third line", "", "next paragraph");
        Line line = documentIterator.getNextLine();

        ParagraphLinesExtractor paragraphLinesExtractor = new ParagraphLinesExtractor();
        List<Line> extractedLines = paragraphLinesExtractor.extract(documentIterator);

        assertNotNull(extractedLines);
        assertEquals(3, extractedLines.size());
        assertEquals("first line", extractedLines.get(0).asString());
        assertEquals("second line", extractedLines.get(1).asString());
        assertEquals("third line", extractedLines.get(2).asString());
        assertEquals(3, documentIterator.getIndex());
    }

    @Test
    @DisplayName("one line")
    void oneLine() {

        DocumentIterator documentIterator = DocumentIterator.getInstance("first line", "", "second line");
        Line line = documentIterator.getNextLine();

        ParagraphLinesExtractor paragraphLinesExtractor = new ParagraphLinesExtractor();
        List<Line> extractedLines = paragraphLinesExtractor.extract(documentIterator);

        assertNotNull(extractedLines);
        assertEquals(1, extractedLines.size());
        assertEquals("first line", extractedLines.get(0).asString());
        assertEquals(1, documentIterator.getIndex());
    }

}