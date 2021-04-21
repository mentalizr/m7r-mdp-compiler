package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

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
        HeadingExtractor headingLinesExtractor = new HeadingExtractor();
        Extraction extraction = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(1, extraction.getNrOfLines());
        assertEquals("# Eine Überschrift", extraction.getTagLine().asString());
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
        HeadingExtractor headingLinesExtractor = new HeadingExtractor();
        Extraction extraction = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(1, extraction.getNrOfLines());
        assertEquals("## Eine Überschrift", extraction.getTagLine().asString());
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
        HeadingExtractor headingLinesExtractor = new HeadingExtractor();
        Extraction extraction = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(1, extraction.getNrOfLines());
        assertEquals("##### Eine Überschrift", extraction.getTagLine().asString());
    }

}