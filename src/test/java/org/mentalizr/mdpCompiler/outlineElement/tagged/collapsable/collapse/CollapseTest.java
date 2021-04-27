package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion.AccordionFactory;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

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

    @Test
    void nestedImgText() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new CollapseFactory())
                        .withMDPLines(
                                "@collapse[id=\"id4711\" \"showFirst\"]",
                                "--- Header 1",
                                "    @img-text[alt=\"picture one\"](picture_one.png)",
                                "        Some text, part of img-text",
                                "",
                                "    some further text, not part of img-text",
                                "--- Header 2",
                                "    # Content Card 2",
                                "",
                                "    * erster Punkt",
                                "    * zweiter Punkt",
                                "--- Header 3",
                                "    Hier ein Pragraph mit *kursivem* Inhalt",
                                "    und **fett**",
                                "",
                                "Hier folgt was",
                                "Und hier noch was")
                        .withExpectedFile(new File(RESRC_DIR, "collapse-netstedImgText.expected"))
                        .withExpectedDocumentIteratorIndex(14)
        );

    }

}