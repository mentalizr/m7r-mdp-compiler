package org.mentalizr.mdpCompiler.outlineElement.tagged.html;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

class HtmlTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new Html())
                        .withMDPLines("@html[]",
                                "    <p>This is made by custom html</p>")
                        .withExpectedLines(new String[]{
                                "<div class=\"mt-0 mb-0\">",
                                "    <p>This is made by custom html</p>",
                                "</div>"})
                        .withExpectedDocumentIteratorIndex(1)
        );
    }

    @Test
    void withId() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new Html())
                        .withMDPLines("@html[id=\"id4711\"]",
                                "    <p>This is made by custom html</p>")
                        .withExpectedLines(new String[]{
                                "<div id=\"id4711\" class=\"mt-0 mb-0\">",
                                "    <p>This is made by custom html</p>",
                                "</div>"})
                        .withExpectedDocumentIteratorIndex(1)
        );
    }

    @Test
    void withIdAndMargins() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new Html())
                        .withMDPLines("@html[id=\"id4711\" margin-bottom=\"1\" margin-top=\"2\"]",
                                "    <p>This is made by custom html</p>")
                        .withExpectedLines(new String[]{
                                "<div id=\"id4711\" class=\"mt-2 mb-1\">",
                                "    <p>This is made by custom html</p>",
                                "</div>"})
                        .withExpectedDocumentIteratorIndex(1)
        );
    }


}