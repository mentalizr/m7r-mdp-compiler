package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementLinesExtractorBench;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class ULLinesExtractorTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/md/ul/";

    @Test
    void plausibility_pos_1() throws MDPSyntaxError, IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "* first item",
                "* second item",
                "",
                "something completely different"
        );

        OutlineElementLinesExtractorBench.execute(
                ULLinesExtractorTest.class.getSimpleName() + "@plausibility_pos_1",
                documentIterator,
                new ULExtractor(),
                new File(EXPECTED_DIR, "extractor-plausi-1.expected"),
                2
        );
    }

    @Test
    void plausibility_pos_2() throws MDPSyntaxError, IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "* first item",
                "* second item",
                "something completely different"
        );

        OutlineElementLinesExtractorBench.execute(
                ULLinesExtractorTest.class.getSimpleName() + "@plausibility_pos_2",
                documentIterator,
                new ULExtractor(),
                new File(EXPECTED_DIR, "extractor-plausi-1.expected"),
                1
        );
    }

    @Test
    void pos_eol() throws MDPSyntaxError, IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "* first item",
                "* second item"
        );

        OutlineElementLinesExtractorBench.execute(
                ULLinesExtractorTest.class.getSimpleName() + "@pos_eol",
                documentIterator,
                new ULExtractor(),
                new File(EXPECTED_DIR, "extractor-plausi-1.expected"),
                1
        );
    }

    @Test
    void pos_eol_withTrailingBlankLines() throws MDPSyntaxError, IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "* first item",
                "* second item",
                "   ",
                ""
        );

        OutlineElementLinesExtractorBench.execute(
                ULLinesExtractorTest.class.getSimpleName() + "@pos_eol_withTrailingBlankLines",
                documentIterator,
                new ULExtractor(),
                new File(EXPECTED_DIR, "extractor-plausi-1.expected"),
                3
        );
    }

}