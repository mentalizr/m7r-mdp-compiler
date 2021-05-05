package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

import java.io.File;

import static org.junit.jupiter.api.Assertions.fail;

class AccordionTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/collapsable/accordion/";

    @Test
    void plausibility_pos_1() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Accordion())
                .withMDPLines(
                        "@accordion[id=\"i4711\"]",
                        "--- Header 1",
                        "    Content Card 1",
                        "--- Header 2",
                        "    # Content Card 2",
                        "",
                        "    * erster Punkt",
                        "    * zweiter Punkt",
                        "--- Header 3",
                        "    Content Card 3",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                )
                .withExpectedFile(new File(RESRC_DIR, "accordion-plausi-1.expected"))
                .withExpectedDocumentIteratorIndex(10)
                .withMediaResources();

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void inline() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Accordion())
                .withMDPLines(
                        "@accordion[id=\"i4711\"]",
                        "--- Header 1",
                        "    Content *Card 1*",
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
                        "Und hier noch was"
                )
                .withExpectedFile(new File(RESRC_DIR, "accordion-inline.expected"))
                .withExpectedDocumentIteratorIndex(11)
                .withMediaResources();

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void nestedImgText() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Accordion())
                .withMDPLines(
                        "@accordion[id=\"id4711\" \"showFirst\"]",
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
                        "Und hier noch was"
                )
                .withExpectedFile(new File(RESRC_DIR, "accordion-nestedImgText.expected"))
                .withExpectedDocumentIteratorIndex(14)
                .withMediaResources("picture_one.png");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void nestedTwoTimes() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Accordion())
                .withMDPLines(
                        "@accordion[id=\"id4711\" \"showFirst\"]",
                        "--- Header 1",
                        "    @accordion[id=\"id4712\"]",
                        "    --- header 1.1",
                        "        @img-text[alt=\"picture one\"](picture_one.png)",
                        "            Some text, part of img-text",
                        "    --- header 1.2",
                        "        some further text",
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
                        "Und hier noch was"
                )
                .withExpectedFile(new File(RESRC_DIR, "accordion-nested2times.expected"))
                .withExpectedDocumentIteratorIndex(16)
                .withMediaResources("picture_one.png");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void provocation_noCardContent() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Accordion())
                .withMDPLines(
                        "@accordion[id=\"id4711\" \"showFirst\"]",
                        "--- Header 1",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                )
                .withExpectedFile(new File(RESRC_DIR, "accordion-provocation-noCardContent.expected"))
                .withExpectedDocumentIteratorIndex(2)
                .withMediaResources();

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void provocation_noContent() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Accordion())
                .withMDPLines(
                        "@accordion[id=\"id4711\" \"showFirst\"]",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                )
                .withExpectedLines(
                        "<div class=\"accordion mt-3 mb-3\" id=\"id4711\">",
                        "</div>"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources();

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void provocation_malformedContent() {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new Accordion())
                .withMDPLines(
                        "@accordion[id=\"id4711\" \"showFirst\"]",
                        "",
                        "--- header",
                        "    some header content",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                )
                .withExpectedLines(
                        "<div class=\"accordion mt-3 mb-3\" id=\"id4711\">",
                        "</div>"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources();

        try {
            OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
            fail("exception expected");
        } catch (MDPSyntaxError mdpSyntaxError) {
            // do intentionally nothing
        }
    }

}