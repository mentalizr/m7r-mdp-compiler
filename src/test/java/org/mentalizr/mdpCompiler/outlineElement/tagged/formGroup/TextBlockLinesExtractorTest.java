package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupExtractionFactory;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementLinesExtractorBench;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
class TextBlockLinesExtractorTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/formGroup/inputGroup";

    @Test
    void plausi1() throws MDPSyntaxError, IOException {

        Document document = new Document(new File(EXPECTED_DIR, "basic-1.mdp"));
        DocumentIterator documentIterator = document.getDocumentIterator();

        OutlineElementLinesExtractorBench.execute(
                "plausi 1",
                documentIterator,
                new TextBlockExtractor(new InputGroupExtractionFactory()),
                new File(EXPECTED_DIR, "basic-1.extracted.mdp"),
                2
        );
    }

    @Test
    void plausi2() throws MDPSyntaxError, IOException {

        Document document = new Document(new File(EXPECTED_DIR, "input-group_md_ul.mdp"));
        DocumentIterator documentIterator = document.getDocumentIterator();

        OutlineElementLinesExtractorBench.execute(
                "plausi 2",
                documentIterator,
                new TextBlockExtractor(new InputGroupExtractionFactory()),
                new File(EXPECTED_DIR, "input-group_md_ul.extracted.mdp"),
                8
        );
    }

}