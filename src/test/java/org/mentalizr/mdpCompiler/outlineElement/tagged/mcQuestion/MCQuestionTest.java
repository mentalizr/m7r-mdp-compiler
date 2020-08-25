package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.Test;

import java.io.File;

@SuppressWarnings("SpellCheckingInspection")
public class MCQuestionTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/mcQuestion/";

    @Test
    void test() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new MCQuestionFactory())
                        .withMDPLines("@mc-question[id=\"q1\"]",
                                "    Frage 1 von 5",
                                "    Welche zwei Arten von Stressbewältigung unterscheidet der Stressforscher Richard Lazarus in seinem berühmten transaktionalen Stressmodell?",
                                "    - Veränderungszentriert und Vermeidungszentriert",
                                "    + Problemorientiert und Emotionsorientiert",
                                "    - Ablenkungsfokussiert und Emotionsfokussiert",
                                "    - Vermeidungsfokussiert und Problemfokussiert",
                                "",
                                "Hier folgt was",
                                "Und hier noch was")
                        .withExpectedFile(new File(RESRC_DIR, "mcQuestion-plausibility.expected"))
                        .withExpectedDocumentIteratorIndex(7)
        );

    }

}
