package org.mentalizr.mdpCompilerTestResrc;

import de.arthurpicht.utils.io.textfile.TextFile;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutlineElementTestBench {

    @SuppressWarnings("SpellCheckingInspection")
    private static final boolean SOUT_RESULT = true;

    public static void execute(OutlineElementTestBenchExecutor outlineElementTestBenchExecutor) throws MDPSyntaxError {

        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements.length < 2) throw new RuntimeException("Call from external method expected.");
        String testName = "[TEST: " + stackTraceElements[1].getMethodName() + "] [CLASS: " + stackTraceElements[1].getClassName() + "]";

        execute(
                testName,
                outlineElementTestBenchExecutor.getOutlineElementFactory(),
                outlineElementTestBenchExecutor.getMdpLines(),
                outlineElementTestBenchExecutor.getExpectedLines(),
                outlineElementTestBenchExecutor.getExpectedDocumentIteratorIndex()
        );
    }

    public static void execute(OutlineElementFactory outlineElementFactory, String[] mdpLines, String[] expectedHtmlLines, int expectedDocumentIteratorIndex) throws MDPSyntaxError {

        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements.length < 2) throw new RuntimeException("Call from external method expected.");
        String testName = "[TEST: " + stackTraceElements[1].getMethodName() + "] [CLASS: " + stackTraceElements[1].getClassName() + "]";

        execute(testName, outlineElementFactory, mdpLines, expectedHtmlLines, expectedDocumentIteratorIndex);
    }

    public static void execute(OutlineElementFactory outlineElementFactory, String[] mdpLines, File expectedHtmlFile, int expectedDocumentIteratorIndex) throws IOException, MDPSyntaxError {

        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements.length < 2) throw new RuntimeException("Call from external method expected.");
        String testName = "[TEST: " + stackTraceElements[1].getMethodName() + "] [CLASS: " + stackTraceElements[1].getClassName() + "]";

        List<String> expectedLinesAsList = TextFile.getLinesAsStrings(expectedHtmlFile);
        String[] expectedLines = expectedLinesAsList.toArray(new String[0]);

        execute(testName, outlineElementFactory, mdpLines, expectedLines, expectedDocumentIteratorIndex);
    }

    private static void execute(String testName, OutlineElementFactory outlineElementFactory, String[] mdpLines, String[] expectedHtmlLines, int expectedDocumentIteratorIndex) throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance(mdpLines);
        documentIterator.getNextLine();
        Result result = new ResultTest();

        OutlineElement outlineElement = outlineElementFactory.getInstance();
        outlineElement.process(CompilerContext.getDefaultTestContext(), documentIterator, result);

        if (SOUT_RESULT) {
            System.out.println(">>>[OutlineElementTestBench: " + testName + "] generated HTML:");
            for (String htmlLine : result.getResultLines()) {
                System.out.println(htmlLine);
            }
            System.out.println("<<<[OutlineElementTestBench] End of generated HTML");
        }

        List<String> expectedLines = Arrays.asList(expectedHtmlLines);

//        System.out.println("Diff:");
//        String[] resultArray = result.getResultLines().toArray(new String[0]);
//        DiffHelper.showDiff(expectedHtmlLines, resultArray);

        assertEquals(expectedLines, result.getResultLines());
        assertEquals(expectedDocumentIteratorIndex, documentIterator.getIndex());
    }

    @Deprecated
    public static void execute(@SuppressWarnings("SpellCheckingInspection") String testname, DocumentIterator documentIterator, OutlineElementFactory outlineElementFactory, File file, int expectedDocumentIteratorIndex) throws MDPSyntaxError, IOException {

        documentIterator.getNextLine();
        Result result = new ResultTest();

        OutlineElement outlineElement = outlineElementFactory.getInstance();
        outlineElement.process(CompilerContext.getDefaultTestContext(), documentIterator, result);

        if (SOUT_RESULT) {
            System.out.println("###[OutlineElementTestBench] " + testname);
            for (String htmlLine : result.getResultLines()) {
                System.out.println(htmlLine);
            }
            System.out.println("---");
        }

        List<String> expectedLines = TextFile.getLinesAsStrings(file);
        assertEquals(expectedLines, result.getResultLines());
        assertEquals(expectedDocumentIteratorIndex, documentIterator.getIndex());
    }

}
