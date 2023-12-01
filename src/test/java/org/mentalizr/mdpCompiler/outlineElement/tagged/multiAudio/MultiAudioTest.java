package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

import java.io.File;

@SuppressWarnings("SpellCheckingInspection")
public class MultiAudioTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/multiAudio/";

    @Test
    void test() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new MultiAudio())
                        .withMDPLines("@multi-audio[id=\"testId\"]",
                                "    [label1](source1.mp3)",
                                "    [label2](source2.mp3)",
                                "    [label3](source3.mp3)",
                                "",
                                "Hier folgt was",
                                "Und hier noch was")
                        .withExpectedFile(new File(RESRC_DIR, "multiAudio-plausibility.expected"))
                        .withExpectedDocumentIteratorIndex(4)
        );

    }

}
