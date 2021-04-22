package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class H1Test {

    @Test
    void plausibility() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "# Eine Überschrift",
                "",
                "Eine Zeile");
        Line firstLine = documentIterator.getNextLine();
        System.out.println("first Line: " + firstLine.asString());
        Result result = new ResultTest();

        H1 h1 = new H1();
        h1.process(CompilerContext.getDefaultTestContext(), documentIterator, result);

        List<String> htmlLines = result.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

    @Test
    void testNoEmptyLineAfter() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance("# Eine Überschrift", "Eine Zeile");
        Line firstLine = documentIterator.getNextLine();
        System.out.println("first Line: " + firstLine.asString());
        Result result = new ResultTest();

        H1 h1 = new H1();
        h1.process(CompilerContext.getDefaultTestContext(), documentIterator, result);

        List<String> htmlLines = result.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("<p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

    @Test
    void indentationLevelOne() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance("# Eine Überschrift", "", "Eine Zeile");
        Line firstLine = documentIterator.getNextLine();
        System.out.println("first Line: " + firstLine.asString());
        Result result = new ResultTest();

        H1 h1 = new H1();
        h1.process(new CompilerContext(false, 1), documentIterator, result);

        List<String> htmlLines = result.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("    <p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

    @Test
    void indentationLevelTwo() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance("# Eine Überschrift", "", "Eine Zeile");
        Line firstLine = documentIterator.getNextLine();
        System.out.println("first Line: " + firstLine.asString());
        Result result = new ResultTest();

        H1 h1 = new H1();
        h1.process(new CompilerContext(false, 2), documentIterator, result);

        List<String> htmlLines = result.getResultLines();

        assertNotNull(htmlLines);
        assertEquals(1, htmlLines.size());
        assertEquals("        <p class=\"h1 mt-4 mb-4\">Eine Überschrift</p>", htmlLines.get(0));
    }

}