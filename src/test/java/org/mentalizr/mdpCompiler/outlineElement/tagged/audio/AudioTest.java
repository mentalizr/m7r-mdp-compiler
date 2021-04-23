package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;

class AudioTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new AudioFactory(),
                new String[] {
                        "@audio[](myAudio.mp3)",
                        "Something completely different ..."
                },
                new String[] {
                        "<audio class=\"mt-0 mb-0\" preload=\"none\" style=\"width: 100%;\" controls=\"controls\">",
                        "    <source type=\"audio/mpeg\" src=\"service/v1/mediaAV/myAudio.mp3\"/>",
                        "    <a href=\"service/v1/mediaAV/myAudio.mp3\">service/v1/mediaAV/myAudio.mp3</a>",
                        "</audio>"
                },
                1
        );
    }
}