package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

@SuppressWarnings("SpellCheckingInspection")
class ImgFluidTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ImgFluid())
                .withMDPLines(
                        "@img-fluid[alt=\"Ein alternativer Text\"](link)",
                        "Something completely different ..."
                )
                .withExpectedLines(
                        "<img src=\"service/v1/mediaImg/link\" class=\"img-fluid mb-0 mt-0\" style=\"width: 100%\" alt=\"Ein alternativer Text\">"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("link");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void marginTopTest() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ImgFluid())
                .withMDPLines(
                        "@img-fluid[alt=\"Ein alternativer Text\" margin-top=\"2\"](link)",
                        "Something completely different ..."
                )
                .withExpectedLines(
                        "<img src=\"service/v1/mediaImg/link\" class=\"img-fluid mb-0 mt-2\" style=\"width: 100%\" alt=\"Ein alternativer Text\">"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("link");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void marginBottomTest() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ImgFluid())
                .withMDPLines(
                        "@img-fluid[alt=\"Ein alternativer Text\" margin-bottom=\"1\"](link)",
                        "Something completely different ..."
                )
                .withExpectedLines(
                        "<img src=\"service/v1/mediaImg/link\" class=\"img-fluid mb-1 mt-0\" style=\"width: 100%\" alt=\"Ein alternativer Text\">"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("link");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

}