package org.mentalizr.mdpCompiler.outlineElement.md.table;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class TableTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/md/table/";

    @Test
    @DisplayName("basic-1")
    void basic1() throws MDPSyntaxError, IOException {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new TableFactory())
                .withMDPLines(
                        "| Header 1 | Header 2 | Header 3 |",
                        "| ---- | :----: | ----: |",
                        "| C1R1 | C2R1 | C3R1 |",
                        "| C1R2 | C2R2 | C3R2 |",
                        ""
                )
                .withExpectedFile(new File(EXPECTED_DIR, "basic-1.expected"))
                .withExpectedDocumentIteratorIndex(4);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);

    }

    @Test
    @DisplayName("withoutHeader")
    void withoutHeader() throws MDPSyntaxError, IOException {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new TableFactory())
                .withMDPLines(
                        "|",
                        "| ---- | :----: | ----: |",
                        "| C1R1 | C2R1 | C3R1 |",
                        "| C1R2 | C2R2 | C3R2 |",
                        ""
                )
                .withExpectedFile(new File(EXPECTED_DIR, "withoutHeader.expected"))
                .withExpectedDocumentIteratorIndex(4);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    @DisplayName("inlineElements1")
    void inlineElements1() throws MDPSyntaxError, IOException {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new TableFactory())
                .withMDPLines(
                        "| Header 1 | Header 2 | Header 3 |",
                        "| ---- | :----: | ----: |",
                        "| C1R1 *kursiv* | C2R1 | C3R1 |",
                        "| C1R2 | C2R2 | C3R2 |",
                        ""
                )
                .withExpectedFile(new File(EXPECTED_DIR, "inlineElements-1.expected"))
                .withExpectedDocumentIteratorIndex(4);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

}