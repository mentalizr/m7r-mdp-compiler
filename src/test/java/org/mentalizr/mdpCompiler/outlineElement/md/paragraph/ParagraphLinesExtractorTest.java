package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParagraphLinesExtractorTest {

    @Test
    @DisplayName("plausibility positive 1")
    void plausibility_pos_1() {

        DocumentIterator documentIterator = DocumentIterator.getInstance("first line", "second line", "third line", "", "next paragraph");
        Line line = documentIterator.getNextLine();

        ParagraphExtractor paragraphLinesExtractor = new ParagraphExtractor();
        Extraction extraction = paragraphLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(3, extraction.getNrOfLines());
        assertEquals("first line", extraction.getLines().get(0).asString());
        assertEquals("second line", extraction.getLines().get(1).asString());
        assertEquals("third line", extraction.getLines().get(2).asString());
        assertEquals(3, documentIterator.getIndex());
    }

    @Test
    @DisplayName("one line")
    void oneLine() {

        DocumentIterator documentIterator = DocumentIterator.getInstance("first line", "", "second line");
        Line line = documentIterator.getNextLine();

        ParagraphExtractor paragraphLinesExtractor = new ParagraphExtractor();
        Extraction extraction = paragraphLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(1, extraction.getNrOfLines());
        assertEquals("first line", extraction.getLines().get(0).asString());
        assertEquals(1, documentIterator.getIndex());
    }

}