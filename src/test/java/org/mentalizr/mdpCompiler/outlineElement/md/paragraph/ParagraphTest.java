package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

class ParagraphTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/md/paragraph/";

    @Test
    @DisplayName("One Line")
    void oneLine() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ParagraphFactory())
                .withMDPLines(
                        "Was ist eigentlich mit mir los, was stimmt mit mir nicht ...",
                        "")
                .withExpectedFile(new File(EXPECTED_DIR, "oneLine-1.expected"))
                .withExpectedDocumentIteratorIndex(1);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    @DisplayName("One Line EOF")
    void oneLineEOF() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ParagraphFactory())
                .withMDPLines("Was ist eigentlich mit mir los, was stimmt mit mir nicht ...")
                .withExpectedFile(new File(EXPECTED_DIR, "oneLine-1.expected"))
                .withExpectedDocumentIteratorIndex(0);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    @DisplayName("Multi Line")
    void multiLine() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ParagraphFactory())
                .withMDPLines(
                        "Was ist eigentlich mit mir los, was stimmt mit mir nicht ...",
                        "eine zeite Zeile",
                        "eine dritte Zeile",
                        "")
                .withExpectedFile(new File(EXPECTED_DIR, "multiLine.expected"))
                .withExpectedDocumentIteratorIndex(3);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    @DisplayName("Multi Line with inline content")
    void multiLineWithInlineContent() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new ParagraphFactory(),
                new String[]{
                        "Was ist eigentlich mit mir los, was stimmt mit mir nicht ...",
                        "eine zeite Zeile mit *kursivem* und **fettem** Inhalt",
                        "eine dritte Zeile mit ***kursiv und fettem*** Inhalt und hier `Code`",
                        ""
                },
                new String[]{
                        "<p>Was ist eigentlich mit mir los, was stimmt mit mir nicht ...",
                        "eine zeite Zeile mit <em>kursivem</em> und <strong>fettem</strong> Inhalt",
                        "eine dritte Zeile mit <em><strong>kursiv und fettem</strong></em> Inhalt und hier <code>Code</code></p>"
                },
                3
        );
    }

}