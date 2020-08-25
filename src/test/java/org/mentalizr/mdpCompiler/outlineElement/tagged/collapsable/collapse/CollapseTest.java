package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.Test;

import java.io.File;

@SuppressWarnings("SpellCheckingInspection")
class CollapseTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/collapsable/collapse/";

    @Test
    public void plausibility() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new CollapseFactory())
                        .withMDPLines("@collapse[id=\"id4711\"]",
                                "--- One",
                                "    Here some content",
                                "--- Two",
                                "    # Here some complex content",
                                "",
                                "    Text with *italic* and **bold** content.",
                                "",
                                "Something different")
                        .withExpectedFile(new File(RESRC_DIR, "collapse-plausibility.expected"))
                        .withExpectedDocumentIteratorIndex(7)
        );

    }

}