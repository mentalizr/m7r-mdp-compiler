package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
class ImgTextTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/imgText/";

    @Test
    void plausibilityTest() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new ImgTextFactory(),
                new String[] {
                        "@img-text[alt=\"Bild\"](picture.mp3)",
                        "    Some text."
                },
                new String[] {
                        "<div class=\"row\" style=\"margin-bottom: 1.0em; margin-top: 1.0em\">",
                        "    <div class=\"col-xs-12 col-sm-5 col-md-5 col-lg-5\">",
                        "        <img src=\"service/v1/mediaImg/picture.mp3\" class=\"img-fluid\" style=\"width: 100%\" alt=\"Bild\">",
                        "    </div>",
                        "    <div class=\"col-xs-12 col-sm-7 col-md-7 col-lg-7\">",
                        "        <p>Some text.</p>",
                        "    </div>",
                        "</div>"
                },
                1
        );
    }

    @Test
    void nestedAccordion() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new ImgTextFactory())
                        .withMDPFile(new File(RESRC_DIR, "imgtext_with_nested_accordion.mdp"))
                        .withExpectedFile(new File(RESRC_DIR, "imgtext_with_nested_accordion.expected"))
                        .withExpectedDocumentIteratorIndex(10)
        );

    }

}