package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import de.arthurpicht.utils.core.collection.Sets;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.mdpTag.MDPTagWithLink;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.md.paragraph.ParagraphModel;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class ImgTextTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/imgText/";

    @Test
    void preconditions() {
        OutlineElementTagged outlineElementTagged = new ImgText();
        assertEquals(ImgText.TAG, outlineElementTagged.getTagName());
    }

    @Test
    void extraction() {

        Document document = new Document(
                "@img-text[alt=\"Bild\"](picture.mp3)",
                "    Some text.",
                "",
                "Next paragraph."
        );

        DocumentIterator documentIterator = new DocumentIterator(document);
        documentIterator.getNextLine();

        OutlineElement imgText = new ImgText();
        Extraction extraction = imgText.getExtraction(documentIterator);

        List<String> exptectedStrings = List.of(
                "@img-text[alt=\"Bild\"](picture.mp3)",
                "    Some text."
        );

        List<String> extractionStrings = Lines.asStrings(extraction.getLines());

        assertEquals(exptectedStrings, extractionStrings);
    }

    @Test
    void model() throws MDPSyntaxError {
        List<Line> extractionLines = Lines.create(
                "@img-text[alt=\"Bild\"](picture.mp3)",
                "    Some text."
        );
        Extraction imgTextExtraction = new ImgTextExtraction(extractionLines);
        OutlineElement imgText = new ImgText();

        OutlineElementModel outlineElementModel = imgText.getModel(imgTextExtraction);

        assertTrue(outlineElementModel instanceof ImgTextModel);
        ImgTextModel imgTextModel = (ImgTextModel) outlineElementModel;

        List<OutlineElementModel> childModels = imgTextModel.getChildModels();
        assertEquals(1, childModels.size());

        Set<String> mediaRessources = imgTextModel.getMediaResources();
        assertEquals(1, mediaRessources.size());
        assertEquals("picture.mp3", Sets.getSomeElement(mediaRessources));

        OutlineElementModel childModel = childModels.get(0);
        assertTrue(childModel instanceof ParagraphModel);

        ParagraphModel paragraphModel = (ParagraphModel) childModel;
        assertEquals(1, paragraphModel.getTextLines().size());
        assertEquals("Some text.", paragraphModel.getTextLines().get(0));
    }

    @Test
    void render() throws MDPSyntaxError {
        OutlineElementTagged imgText = new ImgText();

        Line tagLine = new Line("@img-text[alt=\"Bild\"](picture.mp3)", 0);
        MDPTag mdpTag = new MDPTagWithLink(imgText, tagLine);

        ParagraphModel paragraphModel = new ParagraphModel();
        paragraphModel.addLine("Some text.");

        List<OutlineElementModel> childModels = new ArrayList<>();
        childModels.add(paragraphModel);

        ImgTextModel imgTextModel = new ImgTextModel(mdpTag, childModels);

        HtmlBuilder htmlBuilder = new HtmlBuilder();
        CompilerContext compilerContext = CompilerContext.getDefaultTestContext();

        imgText.render(imgTextModel, compilerContext, htmlBuilder);
        List<String> htmlStrings = htmlBuilder.getHtmlLines();
        List<String> expectedHtmlStrings = List.of(
                "<div class=\"row\" style=\"margin-bottom: 1.0em; margin-top: 1.0em\">",
                "    <div class=\"col-xs-12 col-sm-5 col-md-5 col-lg-5\">",
                "        <img src=\"media/picture.mp3\" class=\"img-fluid\" style=\"width: 100%\" alt=\"Bild\">",
                "    </div>",
                "    <div class=\"col-xs-12 col-sm-7 col-md-7 col-lg-7\">",
                "        <p>Some text.</p>",
                "    </div>",
                "</div>"
        );

        assertEquals(expectedHtmlStrings, htmlStrings);
    }

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ImgText())
                .withMDPLines(
                        "@img-text[alt=\"Bild\"](picture.mp3)",
                        "    Some text."
                )
                .withExpectedLines(
                        "<div class=\"row\" style=\"margin-bottom: 1.0em; margin-top: 1.0em\">",
                        "    <div class=\"col-xs-12 col-sm-5 col-md-5 col-lg-5\">",
                        "        <img src=\"media/picture.mp3\" class=\"img-fluid\" style=\"width: 100%\" alt=\"Bild\">",
                        "    </div>",
                        "    <div class=\"col-xs-12 col-sm-7 col-md-7 col-lg-7\">",
                        "        <p>Some text.</p>",
                        "    </div>",
                        "</div>"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("picture.mp3");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void nestedAccordion() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new OutlineElementTestBenchExecutor(new ImgText())
                        .withMDPFile(new File(RESRC_DIR, "imgtext_with_nested_accordion.mdp"))
                        .withExpectedFile(new File(RESRC_DIR, "imgtext_with_nested_accordion.expected"))
                        .withExpectedDocumentIteratorIndex(10)
        );
    }

}