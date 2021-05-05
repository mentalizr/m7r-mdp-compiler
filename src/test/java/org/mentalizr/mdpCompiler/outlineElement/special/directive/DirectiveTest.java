package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;

class DirectiveTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new Directive(),
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