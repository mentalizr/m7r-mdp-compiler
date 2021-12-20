package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DirectiveRendererTest {

    @Test
    void render() {
        List<String> directiveLines = Arrays.asList("@@name=myName", "@@persistent");
        DirectiveModel directiveModel = new DirectiveModel(directiveLines);
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        DirectiveRenderer directiveRenderer = new DirectiveRenderer();
        directiveRenderer.render(directiveModel, CompilerContext.getDefaultTestContext(), htmlBuilder);

        List<String> htmlLines = htmlBuilder.getHtmlLines();

        assertNotNull(htmlLines);
        assertEquals(5, htmlLines.size());
        assertEquals("<!--", htmlLines.get(0));
        assertEquals("@@name=myName", htmlLines.get(1));
        assertEquals("@@persistent", htmlLines.get(2));
        assertEquals("-->", htmlLines.get(3));
        assertEquals("", htmlLines.get(4));
    }

}