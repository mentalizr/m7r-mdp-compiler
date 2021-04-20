package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import de.arthurpicht.utils.io.textfile.TextFile;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributes;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccordionRendererTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/accordion/";

    @Test
    void render() throws MDPSyntaxError, AttributeProfileException, IOException {

        Result result = new ResultTest();
        AttributesBuilder attributesBuilder = new AttributesBuilder()
                .addAttribute(CollapsableAttributes.ID, "4711")
                .addSimpleAttribute(CollapsableAttributes.SHOW_FIRST)
                .addAttribute(CollapsableAttributes.MARGIN_BOTTOM, "3")
                .addAttribute(CollapsableAttributes.MARGIN_TOP, "3");
        CollapsableAttributes collapsableAttributes = new CollapsableAttributes(attributesBuilder.build());
//        AccordionAttributesParser accordionAttributes = new AccordionAttributesParser(AccordionAttributes.ATTRIBUTE_NAME_ID + "=\"4711\" \"" + AccordionAttributes.ATTRIBUTE_NAME_SHOWFIRST + "\"");

        CollapsableModel collapsableModel = new CollapsableModel();
        collapsableModel.createNextCard("Header 1");
        collapsableModel.addContentLine(new Line("Content Card 1", 2));
        collapsableModel.createNextCard("Header 2");
        collapsableModel.addContentLine(new Line("# Content Card 2", 4));
        collapsableModel.addContentLine(new Line("", 5));
        collapsableModel.addContentLine(new Line("* erster Punkt", 6));
        collapsableModel.addContentLine(new Line("* zweiter Punkt", 7));
        collapsableModel.createNextCard("Header 3");
        collapsableModel.addContentLine(new Line("Content Card 3", 9));

        AccordionRenderer accordionRenderer = new AccordionRenderer(collapsableAttributes, collapsableModel);
        accordionRenderer.render(CompilerContext.getDefaultTestContext(), result);

        for (String htmlLine : result.getResultLines()) {
            System.out.println(htmlLine);
        }

        List<String> expectedLines = TextFile.getLinesAsStrings(new File(RESRC_DIR, "accordion-renderer.expected"));
        assertEquals(expectedLines, result.getResultLines());

    }
}