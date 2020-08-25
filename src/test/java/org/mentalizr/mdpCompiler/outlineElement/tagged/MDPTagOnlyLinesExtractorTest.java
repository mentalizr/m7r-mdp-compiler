package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class MDPTagOnlyLinesExtractorTest {

    @Test
    void plausibilityTest() {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@img-fluid[alt=\"Ein alternativer Text.\"]()",
                "",
                "something completely different"
        );
        documentIterator.getNextLine();

        MDPTagOnlyLinesExtractor mdpTagOnlyLinesExtractor = new MDPTagOnlyLinesExtractor(documentIterator);
        List<Line> lineList = mdpTagOnlyLinesExtractor.extract();

        assertEquals(1, lineList.size());
        assertEquals("@img-fluid[alt=\"Ein alternativer Text.\"]()", lineList.get(0).asString());
    }
}