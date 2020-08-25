package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
class GridTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/grid";

    @Test
    void plausibility_pos_1() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new GridFactory(),
                new String[]{
                        "@grid[id=\"i4711\"]",
                        "--- col-4",
                        "    Content Card 1",
                        "--- col-4",
                        "    # Content Card 2",
                        "",
                        "    * erster Punkt",
                        "    * zweiter Punkt",
                        "--- col-4",
                        "    Content Card 3",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                },
                new File(RESRC_DIR, "grid_plausi_1.expected"),
                10
        );
    }

    @Test
    void default_col_definition() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new GridFactory(),
                new String[]{
                        "@grid[id=\"i4711\"]",
                        "---",
                        "    Content Card 1",
                        "---",
                        "    # Content Card 2",
                        "",
                        "    * erster Punkt",
                        "    * zweiter Punkt",
                        "---",
                        "    Content Card 3",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                },
                new File(RESRC_DIR, "grid_default_col_definition1.expected"),
                10
        );
    }

    @Test
    void default_col_definition_single_col() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new GridFactory(),
                new String[]{
                        "@grid[id=\"i4711\"]",
                        "--- col-4",
                        "    Content Card 1",
                        "---",
                        "    # Content Card 2",
                        "",
                        "    * erster Punkt",
                        "    * zweiter Punkt",
                        "--- col-4",
                        "    Content Card 3",
                        "",
                        "Hier folgt was",
                        "Und hier noch was"
                },
                new File(RESRC_DIR, "grid_default_col_definition_single_col.expected"),
                10
        );
    }


}