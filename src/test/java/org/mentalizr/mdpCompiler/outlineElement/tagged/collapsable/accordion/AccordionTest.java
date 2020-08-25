package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

class AccordionTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/accordion/";

    @Test
    void plausibility_pos_1() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new AccordionFactory(),
                new String[]{
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
                },
                new File(RESRC_DIR, "accordion-plausi-1.expected"),
                10
        );
    }

    @Test
    void inline() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new AccordionFactory(),
                new String[]{
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
                },
                new File(RESRC_DIR, "accordion-inline.expected"),
                11
        );
    }

    @Test
    void nestedImgText() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new AccordionFactory(),
                new String[]{
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
                },
                new File(RESRC_DIR, "accordion-nestedImgText.expected"),
                14
        );
    }

    @Test
    void nestedTwoTimes() throws IOException, MDPSyntaxError {

        OutlineElementTestBench.execute(
                new AccordionFactory(),
                new String[]{
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
                },
                new File(RESRC_DIR, "accordion-nested2times.expected"),
                16
        );
    }

    @Test
    void provocation_noCardContent() throws IOException, MDPSyntaxError {

        OutlineElementTestBench.execute(
                new AccordionFactory(),
                new String[]{
                        "@accordion[id=\"id4711\" \"showFirst\"]",
                        "--- Header 1",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                },
                new File(RESRC_DIR, "accordion-provocation-noCardContent.expected"),
                2
        );
    }

    @Test
    void provocation_noContent() throws IOException, MDPSyntaxError {

        OutlineElementTestBench.execute(
                new AccordionFactory(),
                new String[]{
                        "@accordion[id=\"id4711\" \"showFirst\"]",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                },
                new String[]{
                        "<div class=\"accordion mt-3 mb-3\" id=\"id4711\">",
                        "</div>"
                },
                1
        );
    }

    @Test
    void provocation_malformedContent() {

        try {
            OutlineElementTestBench.execute(
                    new AccordionFactory(),
                    new String[]{
                            "@accordion[id=\"id4711\" \"showFirst\"]",
                            "",
                            "--- header",
                            "    some header content",
                            "",
                            "Hier folgt was",
                            "Und hier noch was"
                    },
                    new String[]{
                            "<div class=\"accordion mt-3 mb-3\" id=\"id4711\">",
                            "</div>"
                    },
                    1
            );
            fail("exception expected");
        } catch (MDPSyntaxError mdpSyntaxError) {
            // do intentionally nothing
        }
    }

}