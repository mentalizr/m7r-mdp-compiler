package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;

@SuppressWarnings("SpellCheckingInspection")
class ImgFluidTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new ImgFluid(),
                new String[]{
                        "@img-fluid[alt=\"Ein alternativer Text\"](link)",
                        "Something completely different ..."
                },
                new String[]{
                        "<img src=\"service/v1/mediaImg/link\" class=\"img-fluid mb-0 mt-0\" style=\"width: 100%\" alt=\"Ein alternativer Text\">"
                },
                1
        );
    }

    @Test
    void marginTopTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new ImgFluid(),
                new String[]{
                        "@img-fluid[alt=\"Ein alternativer Text\" margin-top=\"2\"](link)",
                        "Something completely different ..."
                },
                new String[] {
                        "<img src=\"service/v1/mediaImg/link\" class=\"img-fluid mb-0 mt-2\" style=\"width: 100%\" alt=\"Ein alternativer Text\">"
                },
                1
        );
    }

    @Test
    void marginBottomTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new ImgFluid(),
                new String[]{
                        "@img-fluid[alt=\"Ein alternativer Text\" margin-bottom=\"1\"](link)",
                        "Something completely different ..."
                },
                new String[]{
                        "<img src=\"service/v1/mediaImg/link\" class=\"img-fluid mb-1 mt-0\" style=\"width: 100%\" alt=\"Ein alternativer Text\">"
                },
                1
        );
    }

}