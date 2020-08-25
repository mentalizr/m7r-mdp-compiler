package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class VideoTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new VideoFactory(),
                new String[]{
                        "@video[](myVideo.mp4)",
                        "Something completely different ..."
                },
                new String[]{
                        "<div class=\"embed-responsive embed-responsive-16by9 mt-3 mb-3\">",
                        "    <video class=\"\" controls=\"true\" src=\"service/v1/mediaAV/myVideo.mp4\" onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\"></video>",
                        "</div>"
                },
                1
        );
    }

    @Test
    void posterTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new VideoFactory(),
                new String[]{
                        "@video[poster=\"background.png\"](myVideo.mp4)",
                        "Something completely different ..."
                },
                new String[]{
                        "<div class=\"embed-responsive embed-responsive-16by9 mt-3 mb-3\">",
                        "    <video class=\"\" controls=\"true\" poster=\"service/v1/mediaImg/background.png\" src=\"service/v1/mediaAV/myVideo.mp4\" onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\"></video>",
                        "</div>"
                },
                1
        );
    }

    @Test
    void marginTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new VideoFactory(),
                new String[]{
                        "@video[poster=\"background.png\" margin-top=\"1\" margin-bottom=\"2\"](myVideo.mp4)",
                        "Something completely different ..."
                },
                new String[]{
                        "<div class=\"embed-responsive embed-responsive-16by9 mt-1 mb-2\">",
                        "    <video class=\"\" controls=\"true\" poster=\"service/v1/mediaImg/background.png\" src=\"service/v1/mediaAV/myVideo.mp4\" onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\"></video>",
                        "</div>"
                },
                1
        );
    }

}