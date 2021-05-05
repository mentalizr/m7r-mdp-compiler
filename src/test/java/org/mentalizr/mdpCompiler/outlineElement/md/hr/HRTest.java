package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

class HRTest {

    @Test
    void test() throws MDPSyntaxError {
        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new HR())
                .withMDPLines(
                        "---",
                        "",
                        "Some text"
                )
                .withExpectedLines(
                        "<hr/>"
                )
                .withExpectedDocumentIteratorIndex(0);
        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

}