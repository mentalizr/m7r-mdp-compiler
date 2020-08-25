package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.junit.jupiter.api.Test;

class CommentTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new CommentFactory(),
                new String[]{
                        "// some comment",
                        "",
                        "something completely different"
                },
                new String[]{
                },
                0
        );
    }

    @Test
    void multiLineComment() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new CommentFactory(),
                new String[]{
                        "// some comment",
                        "// some more comment",
                        "",
                        "something completely different"
                },
                new String[]{
                },
                1
        );
    }

}