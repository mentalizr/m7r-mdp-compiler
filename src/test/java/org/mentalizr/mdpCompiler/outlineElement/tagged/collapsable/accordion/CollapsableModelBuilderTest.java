package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollapsableModelBuilderTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/accordion/";

    @Test
    void buildModel() throws IOException, MDPSyntaxError, AttributeProfileException {

        AttributesBuilder attributesBuilder = new AttributesBuilder()
                .addAttribute(CollapsableAttributes.ID, "4711")
                .addSimpleAttribute(CollapsableAttributes.SHOW_FIRST);
        CollapsableAttributes collapsableAttributes = new CollapsableAttributes(attributesBuilder.build());

        Document document = new Document(new File(EXPECTED_DIR, "extractor-plausi-1.expected"));
//        List<Line> lines = document.getLines();
        Extraction extraction = new CollapsableExtraction(document);

        CollapsableModelBuilder collapsableModelBuilder = new CollapsableModelBuilder(collapsableAttributes);
        CollapsableModel collapsableModel = collapsableModelBuilder.getModel(extraction);
        List<CollapsableCardContent> collapsableCardContentList = collapsableModel.getCollapsableCardContentList();

        assertEquals(3, collapsableCardContentList.size());

        CollapsableCardContent collapsableCardContent1 = collapsableCardContentList.get(0);
        assertEquals("Header 1", collapsableCardContent1.getHeader());

        List<Line> cardContent1Content = collapsableCardContent1.getContent();
        assertEquals(1, cardContent1Content.size());
        assertEquals("Content Card 1", cardContent1Content.get(0).asString());

        CollapsableCardContent collapsableCardContent2 = collapsableCardContentList.get(1);
        assertEquals("Header 2", collapsableCardContent2.getHeader());

        List<Line> cardContent2Content = collapsableCardContent2.getContent();
        assertEquals(4, cardContent2Content.size());
        assertEquals("# Content Card 2", cardContent2Content.get(0).asString());
        assertEquals("", cardContent2Content.get(1).asString());
        assertEquals("* erster Punkt", cardContent2Content.get(2).asString());
        assertEquals("* zweiter Punkt", cardContent2Content.get(3).asString());

        CollapsableCardContent collapsableCardContent3 = collapsableCardContentList.get(2);
        assertEquals("Header 3", collapsableCardContent3.getHeader());

        List<Line> cardContent3Content = collapsableCardContent3.getContent();
        assertEquals(1, cardContent3Content.size());
        assertEquals("Content Card 3", cardContent3Content.get(0).asString());
    }

    @Test
    void nestedContent() throws MDPSyntaxError, AttributeProfileException {

        AttributesBuilder attributesBuilder = new AttributesBuilder()
                .addAttribute(CollapsableAttributes.ID, "4711")
                .addSimpleAttribute(CollapsableAttributes.SHOW_FIRST);
        CollapsableAttributes collapsableAttributes = new CollapsableAttributes(attributesBuilder.build());

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

        CollapsableModelBuilder collapsableModelBuilder = new CollapsableModelBuilder(collapsableAttributes);
        CollapsableModel collapsableModel = collapsableModelBuilder.getModel(new CollapsableExtraction(lines));
        List<CollapsableCardContent> collapsableCardContentList = collapsableModel.getCollapsableCardContentList();

        assertEquals(1, collapsableCardContentList.size());

        CollapsableCardContent collapsableCardContent1 = collapsableCardContentList.get(0);
        assertEquals("Header 1", collapsableCardContent1.getHeader());

        List<Line> cardContent1Content = collapsableCardContent1.getContent();
        assertEquals(2, cardContent1Content.size());
        assertEquals("@img-text[alt=\"alternative text\"](picture.png)", cardContent1Content.get(0).asString());
        assertEquals("    Here some text for img-text.", cardContent1Content.get(1).asString());
    }

}