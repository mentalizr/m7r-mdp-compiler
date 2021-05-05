package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableExtractor;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementLinesExtractorBench;

import java.io.File;
import java.io.IOException;

class CollapsableLinesExtractorTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/collapsable/accordion/";

    @Test
    void plausibility_1() throws IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@accordion[id=\"i4711\"]",
                "--- Header 1",
                "    Content Card 1",
                "--- Header 2",
                "    # Content Card 2",
                "",
                "    * erster Punkt",
                "    * zweiter Punkt",
                "--- Header 3",
                "    Content Card 3",
                "",
                "Hier folgt was",
                "Und hier noch was"
        );

        OutlineElementLinesExtractorBench.execute(
                "plausi-1",
                documentIterator,
                new CollapsableExtractor(),
                new File(EXPECTED_DIR, "extractor-plausi-1.expected"),
                10
        );
    }

    @Test
    void terminationWithoutEmptyLine() throws IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@accordion[id=\"i4711\"]",
                "--- Header 1",
                "    Content Card 1",
                "--- Header 2",
                "    # Content Card 2",
                "",
                "    * erster Punkt",
                "    * zweiter Punkt",
                "--- Header 3",
                "    Content Card 3",
                "Hier folgt was",
                "Und hier noch was"
        );

        OutlineElementLinesExtractorBench.execute(
                "plausi-1 no empty line",
                documentIterator,
                new CollapsableExtractor(),
                new File(EXPECTED_DIR, "extractor-plausi-1.expected"),
                9
        );

    }

}