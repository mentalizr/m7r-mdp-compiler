package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HeadingLinesExtractorTest {

    @Test
    void plausibility_pos_h1() {

        DocumentIterator documentIterator = DocumentIterator.getInstanceWithIndexOnFirstLine(
                "# Eine Überschrift",
                "",
                "erste Zeile",
                "zweite Zeile"
        );
        HeadingExtractor headingLinesExtractor = new HeadingExtractor();
        Extraction extraction = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(1, extraction.getNrOfLines());
        assertEquals("# Eine Überschrift", extraction.getTagLine().asString());
    }

    @Test
    void plausibility_pos_h2() {

        DocumentIterator documentIterator = DocumentIterator.getInstanceWithIndexOnFirstLine(
                "## Eine Überschrift",
                "",
                "erste Zeile",
                "zweite Zeile"
        );

        HeadingExtractor headingLinesExtractor = new HeadingExtractor();
        Extraction extraction = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(1, extraction.getNrOfLines());
        assertEquals("## Eine Überschrift", extraction.getTagLine().asString());
    }

    @Test
    void plausibility_pos_h5() {

        DocumentIterator documentIterator = DocumentIterator.getInstanceWithIndexOnFirstLine(
                "##### Eine Überschrift",
                "",
                "erste Zeile",
                "zweite Zeile"
        );

        HeadingExtractor headingLinesExtractor = new HeadingExtractor();
        Extraction extraction = headingLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(1, extraction.getNrOfLines());
        assertEquals("##### Eine Überschrift", extraction.getTagLine().asString());
    }

}