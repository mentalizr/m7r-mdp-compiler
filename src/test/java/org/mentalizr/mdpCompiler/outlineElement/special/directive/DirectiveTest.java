package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.junit.jupiter.api.Test;

class DirectiveTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new DirectiveFactory(),
                new String[]{
                        "@@name=myName",
                        "@@persistent",
                        "",
                        "Hier noch was anderes"
                },
                new String[]{
                        "<!--",
                        "@@name=myName",
                        "@@persistent",
                        "-->",
                        ""
                },
                1
        );
    }

}