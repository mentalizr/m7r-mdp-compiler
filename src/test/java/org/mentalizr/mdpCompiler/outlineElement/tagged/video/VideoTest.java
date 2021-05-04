package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

@SuppressWarnings("SpellCheckingInspection")
class VideoTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Video())
                .withMDPLines(
                        "@video[](myVideo.mp4)",
                        "Something completely different ..."
                )

                .withExpectedLines(
                        "<div class=\"embed-responsive embed-responsive-16by9 mt-3 mb-3\">",
                        "    <video class=\"\" preload=\"metadata\" controls=\"true\" src=\"service/v1/mediaAV/myVideo.mp4\" onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\"></video>",
                        "</div>"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("myVideo.mp4");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void posterTest() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Video())
                .withMDPLines(
                        "@video[poster=\"background.png\"](myVideo.mp4)",
                        "Something completely different ..."
                )

                .withExpectedLines(
                        "<div class=\"embed-responsive embed-responsive-16by9 mt-3 mb-3\">",
                        "    <video class=\"\" preload=\"metadata\" controls=\"true\" poster=\"service/v1/mediaImg/background.png\" src=\"service/v1/mediaAV/myVideo.mp4\" onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\"></video>",
                        "</div>"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("myVideo.mp4");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void marginTest() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Video())
                .withMDPLines(
                        "@video[poster=\"background.png\" margin-top=\"1\" margin-bottom=\"2\"](myVideo.mp4)",
                        "Something completely different ..."
                )

                .withExpectedLines(
                        "<div class=\"embed-responsive embed-responsive-16by9 mt-1 mb-2\">",
                        "    <video class=\"\" preload=\"metadata\" controls=\"true\" poster=\"service/v1/mediaImg/background.png\" src=\"service/v1/mediaAV/myVideo.mp4\" onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\"></video>",
                        "</div>"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("myVideo.mp4");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

}