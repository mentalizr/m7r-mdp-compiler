package org.mentalizr.mdpCompilerTestResrc;

import de.arthurpicht.utils.io.textfile.TextFile;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutlineElementTestBench {

    @SuppressWarnings("SpellCheckingInspection")
    private static final boolean SOUT_RESULT = true;

    public static void execute(OutlineElementTestBenchExecutor outlineElementTestBenchExecutor) throws MDPSyntaxError {

        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements.length < 2) throw new RuntimeException("Call from external method expected.");
        String testName = "[TEST: " + stackTraceElements[1].getMethodName() + "] [CLASS: " + stackTraceElements[1].getClassName() + "]";

        String[] mdpLines = outlineElementTestBenchExecutor.getMdpLines();
        DocumentIterator documentIterator = DocumentIterator.getInstanceWithIndexOnFirstLine(mdpLines);
        HtmlBuilder htmlBuilder = new HtmlBuilder();

        OutlineElement outlineElement = outlineElementTestBenchExecutor.getOutlineElement();
        Extraction extraction = outlineElement.getExtraction(documentIterator);
        OutlineElementModel outlineElementModel = outlineElement.getModel(extraction);
        outlineElement.render(outlineElementModel, CompilerContext.getDefaultTestContext(), htmlBuilder);

        if (SOUT_RESULT) {
            System.out.println(">>>[OutlineElementTestBench: " + testName + "] generated HTML:");
            for (String htmlLine : htmlBuilder.getHtmlLines()) {
                System.out.println(htmlLine);
            }
            System.out.println("<<<[OutlineElementTestBench] End of generated HTML");
        }

        String[] expectedHtmlLines = outlineElementTestBenchExecutor.getExpectedLines();
        List<String> expectedLines = Arrays.asList(expectedHtmlLines);

//        System.out.println("Diff:");
//        String[] resultArray = result.getResultLines().toArray(new String[0]);
//        DiffHelper.showDiff(expectedHtmlLines, resultArray);

        assertEquals(expectedLines, htmlBuilder.getHtmlLines());

        if (outlineElementTestBenchExecutor.hasExpectedDocumentIteratorIndex()) {
            int expectedDocumentIteratorIndex = outlineElementTestBenchExecutor.getExpectedDocumentIteratorIndex();
            assertEquals(expectedDocumentIteratorIndex, documentIterator.getIndex());
        }

        if (outlineElementTestBenchExecutor.hasExpectedMediaResources()) {
            Set<String> expectedMediaResources = outlineElementTestBenchExecutor.getExpectedMediaResources();
            assertEquals(expectedMediaResources, outlineElementModel.getMediaResources());
        }
    }

    public static void execute(OutlineElement outlineElement, String[] mdpLines, String[] expectedHtmlLines, int expectedDocumentIteratorIndex) throws MDPSyntaxError {

        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements.length < 2) throw new RuntimeException("Call from external method expected.");
        String testName = "[TEST: " + stackTraceElements[1].getMethodName() + "] [CLASS: " + stackTraceElements[1].getClassName() + "]";

        execute(testName, outlineElement, mdpLines, expectedHtmlLines, expectedDocumentIteratorIndex);
    }

    public static void execute(OutlineElement outlineElement, String[] mdpLines, File expectedHtmlFile, int expectedDocumentIteratorIndex) throws IOException, MDPSyntaxError {

        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements.length < 2) throw new RuntimeException("Call from external method expected.");
        String testName = "[TEST: " + stackTraceElements[1].getMethodName() + "] [CLASS: " + stackTraceElements[1].getClassName() + "]";

        List<String> expectedLinesAsList = TextFile.getLinesAsStrings(expectedHtmlFile);
        String[] expectedLines = expectedLinesAsList.toArray(new String[0]);

        execute(testName, outlineElement, mdpLines, expectedLines, expectedDocumentIteratorIndex);
    }

    private static void execute(String testName, OutlineElement outlineElement, String[] mdpLines, String[] expectedHtmlLines, int expectedDocumentIteratorIndex) throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstanceWithIndexOnFirstLine(mdpLines);
        HtmlBuilder htmlBuilder = new HtmlBuilder();

        Extraction extraction = outlineElement.getExtraction(documentIterator);
        OutlineElementModel outlineElementModel = outlineElement.getModel(extraction);
        outlineElement.render(outlineElementModel, CompilerContext.getDefaultTestContext(), htmlBuilder);

        if (SOUT_RESULT) {
            System.out.println(">>>[OutlineElementTestBench: " + testName + "] generated HTML:");
            for (String htmlLine : htmlBuilder.getHtmlLines()) {
                System.out.println(htmlLine);
            }
            System.out.println("<<<[OutlineElementTestBench] End of generated HTML");
        }

        List<String> expectedLines = Arrays.asList(expectedHtmlLines);

//        System.out.println("Diff:");
//        String[] resultArray = result.getResultLines().toArray(new String[0]);
//        DiffHelper.showDiff(expectedHtmlLines, resultArray);

        assertEquals(expectedLines, htmlBuilder.getHtmlLines());
        assertEquals(expectedDocumentIteratorIndex, documentIterator.getIndex());
    }


}
