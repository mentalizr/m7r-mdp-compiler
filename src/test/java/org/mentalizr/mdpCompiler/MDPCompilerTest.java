package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.helper.TextFile;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class MDPCompilerTest {

    private static final String RESRC_DIR = "src/test/resrc/integration/";

    @Test
    void compileSubdocument() throws MDPSyntaxError, IOException {

        Document document = new Document(
                "# Eine Überschrift",
                "",
                "* one",
                "* two",
                "* three"
        );

        Result result = new ResultTest();
        CompilerContext compilerContext = new CompilerContext(true, 0);

        MDPCompiler.compileSubdocument(document, result, compilerContext);

//        for (String resultLine : result.getResultLines()) {
//            System.out.println(resultLine);
//        }

        List<String> expectedResult = TextFile.getLinesAsStrings(new File(RESRC_DIR, "MDPCompilerTest_compileSubdocument.expected"));

        assertEquals(expectedResult, result.getResultLines());
    }
}