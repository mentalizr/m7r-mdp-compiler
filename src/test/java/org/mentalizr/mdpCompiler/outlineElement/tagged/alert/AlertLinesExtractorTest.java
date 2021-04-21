package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableExtractor;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementLinesExtractorBench;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class AlertLinesExtractorTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/alert/";

    @Test
    void plausi1() throws MDPSyntaxError, IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@alert[type=\"info\" headersize=\"3\"]",
                "    Hier der Info-Text!"
        );

        OutlineElementLinesExtractorBench.execute(
                "plausi 1",
                documentIterator,
                new CollapsableExtractor(),
                new File(EXPECTED_DIR, "extractor-plausi-1.expected"),
                1
        );

    }
}