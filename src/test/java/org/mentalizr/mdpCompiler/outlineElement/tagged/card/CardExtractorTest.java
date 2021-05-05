package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableExtractor;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementLinesExtractorBench;

import java.io.File;
import java.io.IOException;
import java.util.List;

class CardExtractorTest {

    @Test
    void plausibilitySingleLine() throws IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@card[]",
                "    Hier der Text!",
                "",
                "Hier noch was anderes"
        );

        OutlineElementLinesExtractorBench.execute(
                "plausibility single line",
                documentIterator,
                new CollapsableExtractor(),
                List.of(
                        "@card[]",
                        "    Hier der Text!"
                ),
                2
        );
    }

    @Test
    void plausibilityMultiLine() throws IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@card[]",
                "    Here some text!",
                "",
                "    * one",
                "    * two",
                "",
                "Hier noch was anderes"
        );

        OutlineElementLinesExtractorBench.execute(
                "plausibility multi line",
                documentIterator,
                new CollapsableExtractor(),
                List.of(
                        "@card[]",
                        "    Here some text!",
                        "",
                        "    * one",
                        "    * two"
                ),
                5
        );
    }

    @Test
    void plausibilitySubElement() throws IOException {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@card[]",
                "    @alert[]",
                "        Some alert text!",
                "",
                "    Some other text",
                "",
                "Hier noch was anderes"
        );

        OutlineElementLinesExtractorBench.execute(
                "plausibility subelement",
                documentIterator,
                new CollapsableExtractor(),
                List.of(
                        "@card[]",
                        "    @alert[]",
                        "        Some alert text!",
                        "",
                        "    Some other text"
                ),
                5
        );
    }




}