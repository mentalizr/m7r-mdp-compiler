package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class ImgCenterTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new ImgCenterFactory(),
                new String[]{
                        "@img-center[alt=\"Ein alternativer Text\"](link)",
                        "Something completely different ..."
                },
                new String[]{
                        "<img src=\"service/v1/mediaImg/link\" class=\"mx-auto d-block mb-0 mt-0\" alt=\"Ein alternativer Text\">"
                },
                1
        );
    }


}