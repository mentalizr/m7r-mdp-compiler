package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeadingRendererTest {

    @Test
    void plausi_pos_h1() throws MDPSyntaxError {

        HeadingModel headingModel = new HeadingModel();
        headingModel.addHeading("Eine Überschrift");

        Result testResult = new ResultTest();

        HeadingRenderer headingRenderer = new HeadingRenderer(testResult, headingModel, 1);
        headingRenderer.render(CompilerContext.getDefaultTestContext());

        List<String> htmlLines = testResult.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

    @Test
    void plausi_pos_h2() throws MDPSyntaxError {

        HeadingModel headingModel = new HeadingModel();
        headingModel.addHeading("Eine Überschrift");

        Result testResult = new ResultTest();

        HeadingRenderer headingRenderer = new HeadingRenderer(testResult, headingModel, 2);
        headingRenderer.render(CompilerContext.getDefaultTestContext());

        List<String> htmlLines = testResult.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<p class=\"h2 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

    @Test
    void plausi_pos_h5() throws MDPSyntaxError {

        HeadingModel headingModel = new HeadingModel();
        headingModel.addHeading("Eine Überschrift");

        Result testResult = new ResultTest();

        HeadingRenderer headingRenderer = new HeadingRenderer(testResult, headingModel, 5);
        headingRenderer.render(CompilerContext.getDefaultTestContext());

        List<String> htmlLines = testResult.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<p class=\"h5 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

}