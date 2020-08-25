package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;

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
        HRLinesExtractor hrLinesExtractor = new HRLinesExtractor(documentIterator);
        List<Line> extractedLines = hrLinesExtractor.extract();

        assertNotNull(extractedLines);
        assertEquals(1, extractedLines.size());
        assertEquals("---", extractedLines.get(0).asString());
    }

}