package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;

import java.io.IOException;

class AccordionRendererTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/collapsable/accordion/";

    @Test
    void render() throws MDPSyntaxError, IOException {

        // TODO Nach vollständigen Refactoring prüfen, ob Aktualisierung von diesem Test Sinn macht

//        Result result = new Result();
//
//        CollapsableLineModel collapsableModel = new CollapsableLineModel(new Accordion());
//        Line tagLine = new Line("@accordion[id=\"i4711\" \"showFirst\"]", 0);
//        MDPTag mdpTag = new MDPTagSimple(new Accordion(), tagLine);
//        collapsableModel.setMdpTag(mdpTag);
//
//        collapsableModel.createNextCard("Header 1");
//        collapsableModel.addContentLine(new Line("Content Card 1", 2));
//        collapsableModel.createNextCard("Header 2");
//        collapsableModel.addContentLine(new Line("# Content Card 2", 4));
//        collapsableModel.addContentLine(new Line("", 5));
//        collapsableModel.addContentLine(new Line("* erster Punkt", 6));
//        collapsableModel.addContentLine(new Line("* zweiter Punkt", 7));
//        collapsableModel.createNextCard("Header 3");
//        collapsableModel.addContentLine(new Line("Content Card 3", 9));
//
//        AccordionRenderer accordionRenderer = new AccordionRenderer();
//        accordionRenderer.render(collapsableModel, CompilerContext.getDefaultTestContext(), result);
//
//        for (String htmlLine : result.getResultLines()) {
//            System.out.println(htmlLine);
//        }
//
//        List<String> expectedLines = TextFile.getLinesAsStrings(new File(RESRC_DIR, "accordion-renderer.expected"));
//        assertEquals(expectedLines, result.getResultLines());

    }
}