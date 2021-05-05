package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HRLinesExtractorTest {

    @Test
    void plausibility_pos_hr() {

        Document document = new Document(
                "---",
                "erste Zeile",
                "zweite Zeile");
        DocumentIterator documentIterator = document.getDocumentIterator();

        Line line = documentIterator.getNextLine();
        HRExtractor hrLinesExtractor = new HRExtractor();
        Extraction extraction = hrLinesExtractor.extract(documentIterator);

        assertNotNull(extraction);
        assertEquals(1, extraction.getNrOfLines());
        assertEquals("---", extraction.getTagLine().asString());
    }

}