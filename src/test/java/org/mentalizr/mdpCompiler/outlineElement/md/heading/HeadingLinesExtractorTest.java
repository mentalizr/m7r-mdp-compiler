package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HeadingLinesExtractorTest {

    @Test
    void plausibility_pos_h1() {

        Document document = new Document(
                "# Eine Überschrift",
                "",
                "erste Zeile",
                "zweite Zeile");
        DocumentIterator documentIterator = document.getDocumentIterator();

        Line line = documentIterator.getNextLine();
//        System.out.println(line.asString());
        HeadingLinesExtractor headingLinesExtractor = new HeadingLinesExtractor();
        List<Line> extractedLines = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extractedLines);
        assertEquals(1, extractedLines.size());
        assertEquals("# Eine Überschrift", extractedLines.get(0).asString());
    }

    @Test
    void plausibility_pos_h2() {

        Document document = new Document(
                "## Eine Überschrift",
                "",
                "erste Zeile",
                "zweite Zeile");
        DocumentIterator documentIterator = document.getDocumentIterator();

        Line line = documentIterator.getNextLine();
        HeadingLinesExtractor headingLinesExtractor = new HeadingLinesExtractor();
        List<Line> extractedLines = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extractedLines);
        assertEquals(1, extractedLines.size());
        assertEquals("## Eine Überschrift", extractedLines.get(0).asString());
    }

    @Test
    void plausibility_pos_h5() {

        Document document = new Document(
                "##### Eine Überschrift",
                "",
                "erste Zeile",
                "zweite Zeile");
        DocumentIterator documentIterator = document.getDocumentIterator();

        Line line = documentIterator.getNextLine();
        HeadingLinesExtractor headingLinesExtractor = new HeadingLinesExtractor();
        List<Line> extractedLines = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extractedLines);
        assertEquals(1, extractedLines.size());
        assertEquals("##### Eine Überschrift", extractedLines.get(0).asString());
    }

}