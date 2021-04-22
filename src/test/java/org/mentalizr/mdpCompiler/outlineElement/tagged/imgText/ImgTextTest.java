package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import de.arthurpicht.utils.core.collection.Lists;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class ImgTextTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/imgText/";

    @Test
    void extraction() throws MDPSyntaxError {

        Document document = new Document(
                "@img-text[alt=\"Bild\"](picture.mp3)",
                "    Some text.");

        Line tagLine = document.getLines().get(0);
        DocumentIterator documentIterator = new DocumentIterator(document);
        documentIterator.getNextLine();

        OutlineElement imgText = new ImgText(tagLine);
        Extraction extraction = imgText.getExtraction(documentIterator);

        List<String> sourceStrings = Lines.asStrings(document.getLines());
        List<String> extractionStrings = Lines.asStrings(extraction.getLines());

        assertEquals(sourceStrings, extractionStrings);
    }

    @Test
    void model() throws MDPSyntaxError {

        List<Line> extractionLines = Lines.create(
                "@img-text[alt=\"Bild\"](picture.mp3)",
                "    Some text."
        );
        Extraction imgTextExtraction = new ImgTextExtraction(extractionLines);
        OutlineElement imgText = new ImgText(imgTextExtraction.getTagLine());

        OutlineElementModel outlineElementModel = imgText.getModel(imgTextExtraction);

        assertTrue(outlineElementModel instanceof TextBlockModel);
        TextBlockModel textBlockModel = (TextBlockModel) outlineElementModel;

        List<Line> textBlockLines = textBlockModel.getTextBlockLines();
        assertEquals(1, textBlockLines.size());
        assertEquals("Some text.", textBlockLines.get(0).asString());
    }

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new ImgTextFactory(),
                new String[] {
                        "@img-text[alt=\"Bild\"](picture.mp3)",
                        "    Some text."
                },
                new String[] {
                        "<div class=\"row\" style=\"margin-bottom: 1.0em; margin-top: 1.0em\">",
                        "    <div class=\"col-xs-12 col-sm-5 col-md-5 col-lg-5\">",
                        "        <img src=\"service/v1/mediaImg/picture.mp3\" class=\"img-fluid\" style=\"width: 100%\" alt=\"Bild\">",
                        "    </div>",
                        "    <div class=\"col-xs-12 col-sm-7 col-md-7 col-lg-7\">",
                        "        <p>Some text.</p>",
                        "    </div>",
                        "</div>"
                },
                1
        );
    }

    @Test
    void nestedAccordion() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new ImgTextFactory())
                        .withMDPFile(new File(RESRC_DIR, "imgtext_with_nested_accordion.mdp"))
                        .withExpectedFile(new File(RESRC_DIR, "imgtext_with_nested_accordion.expected"))
                        .withExpectedDocumentIteratorIndex(10)
        );

    }

}