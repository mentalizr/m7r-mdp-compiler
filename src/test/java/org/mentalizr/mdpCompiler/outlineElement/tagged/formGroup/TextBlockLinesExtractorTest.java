package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgText.ImgTextExtractor;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementLinesExtractorBench;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
class TextBlockLinesExtractorTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/formGroup/inputGroup";

    @Test
    void plausi1() throws IOException {

        Document document = new Document(new File(EXPECTED_DIR, "basic-1.mdp"));
        DocumentIterator documentIterator = document.getDocumentIterator();

        OutlineElementLinesExtractorBench.execute(
                "plausi 1",
                documentIterator,
                new InputGroupExtractor(),
                new File(EXPECTED_DIR, "basic-1.extracted.mdp"),
                2
        );
    }

    @Test
    void plausi2() throws IOException {

        Document document = new Document(new File(EXPECTED_DIR, "input-group_md_ul.mdp"));
        DocumentIterator documentIterator = document.getDocumentIterator();

        OutlineElementLinesExtractorBench.execute(
                "plausi 2",
                documentIterator,
                new ImgTextExtractor(),
                new File(EXPECTED_DIR, "input-group_md_ul.extracted.mdp"),
                8
        );
    }

}