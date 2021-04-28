package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;

import java.io.File;
import java.io.IOException;

class CardTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/card/";

    @Test
    void plausibilitySingleLine() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new Card(),
                new String[]{
                        "@card[]",
                        "    Hier der Text!",
                        "",
                        "Hier noch was anderes"
                },
                new File(EXPECTED_DIR, "card_plausi_singleLine.expected"),
                2
        );
    }

    @Test
    void plausibilityMultiLine() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new Card(),
                new String[]{
                        "@card[]",
                        "    Here some text!",
                        "",
                        "    * one",
                        "    * two",
                        "",
                        "Hier noch was anderes"
                },
                new File(EXPECTED_DIR, "card_plausi_multiLine.expected"),
                5
        );
    }

}