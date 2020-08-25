package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class H3Test {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance("### Header 1", "", "Something completely different");
        documentIterator.getNextLine();
        Result result = new ResultTest();

        H3 h3 = new H3(documentIterator, result);
        h3.process(CompilerContext.getDefaultTestContext());

        List<String> resultLines = result.getResultLines();

        assertEquals(1, resultLines.size());
        assertEquals("<p class=\"h3 mt-4 mb-4\">Header 1</p>", resultLines.get(0));
    }

}