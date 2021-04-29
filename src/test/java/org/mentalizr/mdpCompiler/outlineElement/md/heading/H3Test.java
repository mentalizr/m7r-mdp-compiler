package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

class H3Test {

    @Test
    void plausibilityTest() throws MDPSyntaxError {
        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new H3())
                .withMDPLines(
                        "### A header string",
                        "",
                        "An other line."
                )
                .withExpectedLines(
                        "<p class=\"h3 mt-4 mb-4\">A header string</p>"
                )
                .withExpectedDocumentIteratorIndex(0);
        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

}