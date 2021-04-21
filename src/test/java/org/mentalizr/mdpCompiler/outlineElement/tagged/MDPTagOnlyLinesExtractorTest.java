package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid.ImgFluidExtractionFactory;

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

        MDPTagOnlyExtractor mdpTagOnlyLinesExtractor = new MDPTagOnlyExtractor(new ImgFluidExtractionFactory());
        Extraction extraction = mdpTagOnlyLinesExtractor.extract(documentIterator);

        assertEquals(1, extraction.getNrOfLines());
        assertEquals("@img-fluid[alt=\"Ein alternativer Text.\"]()", extraction.getTagLine().toString());
    }
}