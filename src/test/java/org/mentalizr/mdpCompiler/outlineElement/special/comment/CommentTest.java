package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;

class CommentTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new Comment(),
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
                new Comment(),
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