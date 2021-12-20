package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HeadingRendererTest {

    @Test
    void plausi_pos_h1() {

        HeadingModel headingModel = new HeadingModel(new H1());
        headingModel.addHeading("Eine Überschrift");

        HtmlBuilder testHtmlBuilder = new HtmlBuilder();

        HeadingRenderer headingRenderer = new HeadingRenderer();
        headingRenderer.render(headingModel, CompilerContext.getDefaultTestContext(), testHtmlBuilder);

        List<String> htmlLines = testHtmlBuilder.getHtmlLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

    @Test
    void plausi_pos_h2() {

        HeadingModel headingModel = new HeadingModel(new H2());
        headingModel.addHeading("Eine Überschrift");

        HtmlBuilder testHtmlBuilder = new HtmlBuilder();

        HeadingRenderer headingRenderer = new HeadingRenderer();
        headingRenderer.render(headingModel, CompilerContext.getDefaultTestContext(), testHtmlBuilder);

        List<String> htmlLines = testHtmlBuilder.getHtmlLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<p class=\"h2 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

    @Test
    void plausi_pos_h5() {

        HeadingModel headingModel = new HeadingModel(new H5());
        headingModel.addHeading("Eine Überschrift");

        HtmlBuilder testHtmlBuilder = new HtmlBuilder();

        HeadingRenderer headingRenderer = new HeadingRenderer();
        headingRenderer.render(headingModel, CompilerContext.getDefaultTestContext(), testHtmlBuilder);

        List<String> htmlLines = testHtmlBuilder.getHtmlLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<p class=\"h5 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

}