package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class H1Test {

    @Test
    @DisplayName("Plausibility test")
    void plausibility() throws MDPSyntaxError {
        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new H1())
                .withMDPLines(
                        "# Eine Überschrift",
                        "",
                        "Eine Zeile"
                )
                .withExpectedLines(
                        "<p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>"
                )
                .withExpectedDocumentIteratorIndex(0);
        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void testNoEmptyLineAfter() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new H1())
                .withMDPLines(
                        "# Eine Überschrift",
                        "Eine Zeile"
                )
                .withExpectedLines(
                        "<p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>"
                )
                .withExpectedDocumentIteratorIndex(0);
        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void indentationLevelOne() {
        H1 h1 = new H1();
        HeadingModel headingModel = new HeadingModel(h1);
        headingModel.addHeading("Eine Überschrift");

        CompilerContext compilerContext = new CompilerContext(false, 1);
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        h1.render(headingModel, compilerContext, htmlBuilder);

        List<String> htmlLines = htmlBuilder.getHtmlLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("    <p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

    @Test
    void indentationLevelTwo() {
        H1 h1 = new H1();
        HeadingModel headingModel = new HeadingModel(h1);
        headingModel.addHeading("Eine Überschrift");

        CompilerContext compilerContext = new CompilerContext(false, 2);
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        h1.render(headingModel, compilerContext, htmlBuilder);

        List<String> htmlLines = htmlBuilder.getHtmlLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("        <p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

}