package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;

import java.io.File;
import java.io.IOException;

class AlertTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/alert/";

    @Test
    void plausi1() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new Alert(),
                new String[]{
                        "@alert[type=\"info\" headersize=\"3\"]",
                        "    Hier der Info-Text!",
                        "",
                        "Hier noch was anderes"
                },
                new File(EXPECTED_DIR, "plausi_pos_1.expected"),
                1
        );
    }

    @Test
    void inline() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new Alert(),
                new String[]{
                        "@alert[type=\"info\" headersize=\"3\"]",
                        "    Hier der **Info-Text**!",
                        "",
                        "Hier noch was anderes"
                },
                new File(EXPECTED_DIR, "alert-inline.expected"),
                1
        );
    }

}