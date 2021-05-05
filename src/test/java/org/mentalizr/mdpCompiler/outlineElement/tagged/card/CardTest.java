package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

import java.io.File;
import java.io.IOException;

class CardTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/card/";

    @Test
    void plausibilitySingleLine() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Card())
                .withMDPLines(
                        "@card[]",
                        "    Hier der Text!",
                        "",
                        "Hier noch was anderes"
                )
                .withExpectedFile(new File(EXPECTED_DIR, "card_plausi_singleLine.expected"))
                .withExpectedDocumentIteratorIndex(2)
                .withMediaResources();

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
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

    @Test
    void getMediaResources() throws MDPSyntaxError {

        //TODO wrong indentation in html

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor = new OutlineElementTestBenchExecutor(new Card())
                .withMDPLines(
                        "@card[]",
                        "    Test",
                        "",
//                        "    @video[poster=\"background.png\"](myVideo1.mp4)",
//                        "    @card[]",
//                        "        @card[]",
//                        "            Some card text.",
//                        "            @video[poster=\"background.png\"](myVideo2.mp4)",
//                        "        @video[poster=\"background.png\"](myVideo3.mp4)",
                        "    @audio[](myAudio1.mp4)"
                )
                .withExpectedLines(
                        "<div class=\"card mt-3 mb-3\">",
                        "    <div class=\"card-body\">",
                        "        <p>Test</p>",
                        "<audio class=\"mt-0 mb-0\" preload=\"none\" style=\"width: 100%;\" controls=\"controls\">",
                        "    <source type=\"audio/mpeg\" src=\"service/v1/mediaAV/myAudio1.mp4\"/>",
                        "    <a href=\"service/v1/mediaAV/myAudio1.mp4\">service/v1/mediaAV/myAudio1.mp4</a>",
                        "</audio>",
                        "    </div>",
                        "</div>"
                )
                .withMediaResources("myAudio1.mp4");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }


}