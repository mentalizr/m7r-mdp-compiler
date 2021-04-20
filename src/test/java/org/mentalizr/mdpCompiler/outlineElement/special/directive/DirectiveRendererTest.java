package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectiveRendererTest {

    @Test
    void render() throws MDPSyntaxError {

        List<String> directiveLines = Arrays.asList("@@name=myName", "@@persistent");
        DirectiveModel directiveModel = new DirectiveModel(directiveLines);
        Result result = new ResultTest();
        DirectiveRenderer directiveRenderer = new DirectiveRenderer(directiveModel);
        directiveRenderer.render(CompilerContext.getDefaultTestContext(), result);

        List<String> htmlLines = result.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(5, htmlLines.size());
        assertEquals("<!--", htmlLines.get(0));
        assertEquals("@@name=myName", htmlLines.get(1));
        assertEquals("@@persistent", htmlLines.get(2));
        assertEquals("-->", htmlLines.get(3));
        assertEquals("", htmlLines.get(4));
    }

}