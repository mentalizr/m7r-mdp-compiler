package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.md.heading.HeadingModel;
import org.mentalizr.mdpCompiler.outlineElement.md.paragraph.Paragraph;
import org.mentalizr.mdpCompiler.outlineElement.md.paragraph.ParagraphModel;
import org.mentalizr.mdpCompiler.outlineElement.md.ul.ULModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollapsableModelBuilderTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/collapsable/accordion/";

    @Test
    void buildModel() throws IOException, MDPSyntaxError {

        Document document = new Document(new File(EXPECTED_DIR, "extractor-plausi-1.expected"));
        Extraction extraction = new CollapsableExtraction(document);

        Accordion accordion = new Accordion();
        AccordionModelBuilder accordionModelBuilder = new AccordionModelBuilder();

        AccordionModel accordionModel = accordionModelBuilder.getModel(extraction);
        List<CollapsableCardContent> collapsableCardContentList = accordionModel.getCollapsableCardContentList();

        assertEquals(3, collapsableCardContentList.size());

        CollapsableCardContent card1 = collapsableCardContentList.get(0);
        assertEquals("Header 1", card1.getHeader());
        assertTrue(card1.hasSingleLine());
        assertEquals("Content Card 1", card1.getSingleLine());

        CollapsableCardContent card2 = collapsableCardContentList.get(1);
        assertEquals("Header 2", card2.getHeader());
        assertTrue(card2.hasChildElements());

        List<OutlineElementModel> childElements = card2.getChildElements();
        assertEquals(2, childElements.size());

        OutlineElementModel childElement1 = childElements.get(0);
        assertTrue(childElement1 instanceof HeadingModel);
        HeadingModel childElement1HeadingModel = (HeadingModel) childElement1;
        assertEquals("Content Card 2", childElement1HeadingModel.getHeading());

        OutlineElementModel childElement2 = childElements.get(1);
        assertTrue(childElement2 instanceof ULModel);
        ULModel childElement2ULModel = (ULModel) childElement2;
        assertEquals(2, childElement2ULModel.getItemList().size());
        assertEquals("erster Punkt", childElement2ULModel.getItemList().get(0));
        assertEquals("zweiter Punkt", childElement2ULModel.getItemList().get(1));

        CollapsableCardContent card3 = collapsableCardContentList.get(2);
        assertEquals("Header 3", card3.getHeader());
        assertTrue(card3.hasSingleLine());
        assertEquals("Content Card 3", card3.getSingleLine());
    }

    @Test
    void nestedContent() throws MDPSyntaxError {

        Document document = new Document(
                "@accordion[]",
                "--- Header 1",
                "    @img-text[alt=\"alternative text\"](picture.png)",
                "        Here some text for img-text."
        );

        List<Line> lines = document.getLines();

        for (Line line : lines) {
            System.out.println(line.asString());
        }

        Accordion accordion = new Accordion();
        CollapsableModelBuilder collapsableModelBuilder = new CollapsableModelBuilder(accordion);
        CollapsableModel collapsableModel = collapsableModelBuilder.getModel(new CollapsableExtraction(lines));
        List<CollapsableCardContent> collapsableCardContentList = collapsableModel.getCollapsableCardContentList();

        assertEquals(1, collapsableCardContentList.size());

        CollapsableCardContent collapsableCardContent1 = collapsableCardContentList.get(0);
        assertEquals("Header 1", collapsableCardContent1.getHeader());
        assertTrue(collapsableCardContent1.hasChildElements());
        List<OutlineElementModel> childElements = collapsableCardContent1.getChildElements();
        assertEquals(1, childElements.size());
        OutlineElementModel childElement = childElements.get(0);
        assertTrue(childElement instanceof TextBlockModel);
        // TODO umbauen, wenn ImgText Modell vollständig refactored

//        List<Line> cardContent1Content = collapsableCardContent1.getContent();
//        assertEquals(2, cardContent1Content.size());
//        assertEquals("@img-text[alt=\"alternative text\"](picture.png)", cardContent1Content.get(0).asString());
//        assertEquals("    Here some text for img-text.", cardContent1Content.get(1).asString());
    }

}