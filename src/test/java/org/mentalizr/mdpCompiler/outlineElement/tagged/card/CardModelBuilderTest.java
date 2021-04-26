package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.md.paragraph.ParagraphModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertExtraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardModelBuilderTest {

    @Test
    void getModelSingleLine() throws MDPSyntaxError {

        Document document = new Document(
                "@card[]",
                "    Here some text."
        );
        Extraction extraction = new AlertExtraction(document);

        Card card = new Card();
        CardModelBuilder cardModelBuilder = new CardModelBuilder(card);
        CardModel cardModel = cardModelBuilder.getModel(extraction);

        assertNotNull(cardModel);
        assertTrue(cardModel.hasSingleLine());
        assertEquals("Here some text.", cardModel.getSingleLine());
    }

    @Test
    void getModelMultiLineParagraph() throws MDPSyntaxError {

        Document document = new Document(
                "@card[]",
                "    Here some text.",
                "    Here some other text."

        );
        Extraction extraction = new AlertExtraction(document);

        Card card = new Card();
        CardModelBuilder cardModelBuilder = new CardModelBuilder(card);
        CardModel cardModel = cardModelBuilder.getModel(extraction);

        assertNotNull(cardModel);
        assertFalse(cardModel.hasSingleLine());
        assertTrue(cardModel.hasChildModels());

        List<OutlineElementModel> childModels = cardModel.getChildModels();
        assertEquals(1, childModels.size());

        OutlineElementModel outlineElementModel = childModels.get(0);
        assertTrue(outlineElementModel instanceof ParagraphModel);

        ParagraphModel paragraphModel = (ParagraphModel) outlineElementModel;
        List<String> textLines = paragraphModel.getTextLines();
        assertEquals(2, textLines.size());
        assertEquals("Here some text.", textLines.get(0));
        assertEquals("Here some other text.", textLines.get(1));
    }

    @Test
    void getModelMultiLineSubElement() throws MDPSyntaxError {

        Document document = new Document(
                "@card[]",
                "    @alert[type=\"info\"]",
                "        Some alert text.",
                "",
                "    Some other text.",
                "    And one more line."

        );
        Extraction extraction = new AlertExtraction(document);

        Card card = new Card();
        CardModelBuilder cardModelBuilder = new CardModelBuilder(card);
        CardModel cardModel = cardModelBuilder.getModel(extraction);

        assertNotNull(cardModel);
        assertFalse(cardModel.hasSingleLine());
        assertTrue(cardModel.hasChildModels());

        List<OutlineElementModel> childModels = cardModel.getChildModels();
        assertEquals(2, childModels.size());

        OutlineElementModel outlineElementModelFirst = childModels.get(0);
        assertTrue(outlineElementModelFirst instanceof AlertModel);
        AlertModel alertModel = (AlertModel) outlineElementModelFirst;
        assertEquals("Some alert text.", alertModel.getText());

        OutlineElementModel outlineElementModelSecond = childModels.get(1);
        assertTrue(outlineElementModelSecond instanceof ParagraphModel);
        ParagraphModel paragraphModel = (ParagraphModel) outlineElementModelSecond;
        List<String> textLines = paragraphModel.getTextLines();
        assertEquals(2, textLines.size());
        assertEquals("Some other text.", textLines.get(0));
        assertEquals("And one more line.", textLines.get(1));
    }

    @Test
    void getModelMultiLineMultiNested() throws MDPSyntaxError {

        Document document = new Document(
                "@card[]",
                "    @card[]",
                "        @card[]",
                "            Some card text."
        );
        Extraction extraction = new AlertExtraction(document);

        Card card = new Card();
        CardModelBuilder cardModelBuilder = new CardModelBuilder(card);
        CardModel cardModel = cardModelBuilder.getModel(extraction);

        assertNotNull(cardModel);
        assertFalse(cardModel.hasSingleLine());
        assertTrue(cardModel.hasChildModels());

        List<OutlineElementModel> childModels = cardModel.getChildModels();
        assertEquals(1, childModels.size());

        OutlineElementModel outlineElementModelFirst = childModels.get(0);
        assertTrue(outlineElementModelFirst instanceof CardModel);
        CardModel cardModelNested = (CardModel) outlineElementModelFirst;

        List<OutlineElementModel> childModelNested = cardModelNested.getChildModels();
        assertEquals(1, childModelNested.size());

        OutlineElementModel outlineElementModelSecond = childModelNested.get(0);
        assertTrue(outlineElementModelSecond instanceof CardModel);
        CardModel cardModelNested2 = (CardModel) outlineElementModelSecond;

        assertTrue(cardModelNested2.hasSingleLine());
        assertEquals("Some card text.", cardModelNested2.getSingleLine());
    }

}