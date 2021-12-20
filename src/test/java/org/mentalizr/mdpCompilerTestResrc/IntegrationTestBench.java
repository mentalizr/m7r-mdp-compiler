package org.mentalizr.mdpCompilerTestResrc;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.helper.TextFile;
import org.mentalizr.mdpCompiler.result.Html;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTestBench {

    @SuppressWarnings("SpellCheckingInspection")
    private static final boolean SOUT_RESULT = true;

    public static void execute(File mdpFile, File expectedFile) throws IOException, MDPSyntaxError {

        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements.length < 2) throw new RuntimeException("Call from external method expected.");
        String testName = "[TEST: " + stackTraceElements[1].getMethodName() + "] [CLASS: " + stackTraceElements[1].getClassName() + "]";

        Document document = new Document(mdpFile);
        Html html = MDPCompiler.compile(document);

        if (SOUT_RESULT) {
            System.out.println("### BEGIN ### [IntegrationTestBench] " + testName);
            for (String line : html.getLines()) {
                System.out.println(line);
            }
            System.out.println("### END ### [IntegrationTestBench] " + testName);
        }

        List<String> expectedResult = TextFile.getLinesAsStrings(expectedFile);
        assertEquals(expectedResult, html.getLines());
    }

}
