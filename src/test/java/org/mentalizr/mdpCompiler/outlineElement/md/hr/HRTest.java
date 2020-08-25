package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HRTest {

    @Test
    void test() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance("---", "", "Eine Zeile");
        Line firstLine = documentIterator.getNextLine();
        Result result = new ResultTest();

        HR hr = new HR(documentIterator, result);
        hr.process(CompilerContext.getDefaultTestContext());

        List<String> htmlLines = result.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<hr/>", htmlLines.get(0));
    }

}