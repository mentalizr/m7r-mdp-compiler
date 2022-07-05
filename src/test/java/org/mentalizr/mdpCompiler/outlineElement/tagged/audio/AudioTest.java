package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

import java.util.Set;

class AudioTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {
        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Audio())
                .withMDPLines(
                        "@audio[](myAudio.mp3)",
                        "Something completely different ..."
                )
                .withExpectedLines(
                        "<audio class=\"mt-0 mb-0\" preload=\"none\" style=\"width: 100%;\" controls=\"controls\">",
                        "    <source type=\"audio/mpeg\" src=\"media/myAudio.mp3\"/>",
                        "    <a href=\"media/myAudio.mp3\">media/myAudio.mp3</a>",
                        "</audio>"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("myAudio.mp3");
        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

}