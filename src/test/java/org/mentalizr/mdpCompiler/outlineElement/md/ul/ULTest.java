package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.Test;

import java.io.File;

class ULTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/md/ul/";

    @Test
    void plausi1() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ULFactory())
                .withMDPLines(
                        "* first Item",
                        "* second Item",
                        "* third Item",
                        "",
                        "something completely different"
                )
                .withExpectedFile(new File(EXPECTED_DIR, "plausi-1.expected"))
                .withExpectedDocumentIteratorIndex(3);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void plausiInline() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new ULFactory(),
                new String[]{
                        "* first *italic* Item",
                        "* second **bold** Item",
                        "* third ***bold and italic*** Item with `some code`",
                        "",
                        "something completely different"
                },
                new String[]{
                      "<ul class=\"mb-4\">",
                      "    <li>first <em>italic</em> Item</li>",
                      "    <li>second <strong>bold</strong> Item</li>",
                      "    <li>third <em><strong>bold and italic</strong></em> Item with <code>some code</code></li>",
                      "</ul>"
                },
                3
        );
    }

}
