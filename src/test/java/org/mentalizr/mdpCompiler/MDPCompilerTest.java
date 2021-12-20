package org.mentalizr.mdpCompiler;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.helper.TextFile;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.md.heading.HeadingModel;
import org.mentalizr.mdpCompiler.outlineElement.md.ul.ULModel;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class MDPCompilerTest {

    private static final String RESRC_DIR = "src/test/resrc/integration/";

    @Test
    void getModelsForSubdocument() throws MDPSyntaxError {

        Document document = new Document(
                "# Eine Überschrift",
                "",
                "* one",
                "* two",
                "* three"
        );

        List<OutlineElementModel> models = MDPCompiler.getModelsForSubdocument(document);
        assertEquals(2, models.size());

        OutlineElementModel child1 = models.get(0);
        assertTrue(child1 instanceof HeadingModel);

        HeadingModel headingModel = (HeadingModel) child1;
        assertEquals(1, headingModel.getHeadingLevel());
        assertEquals("Eine Überschrift", headingModel.getHeading());

        OutlineElementModel child2 = models.get(1);
        assertTrue(child2 instanceof ULModel);

        ULModel ulModel = (ULModel) child2;
        List<String> itemList = ulModel.getItemList();
        assertEquals(3, itemList.size());
        assertEquals("one", itemList.get(0));
        assertEquals("two", itemList.get(1));
        assertEquals("three", itemList.get(2));
    }

    @Test
    void renderSubdocument() throws MDPSyntaxError, IOException {

        Document document = new Document(
                "# Eine Überschrift",
                "",
                "* one",
                "* two",
                "* three"
        );

        List<OutlineElementModel> models = MDPCompiler.getModelsForSubdocument(document);
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        CompilerContext compilerContext = new CompilerContext(true, 0);
        MDPCompiler.renderSubdocument(models, htmlBuilder, compilerContext);

        List<String> expectedResult = TextFile.getLinesAsStrings(new File(RESRC_DIR, "MDPCompilerTest_compileSubdocument.expected"));

        assertEquals(expectedResult, htmlBuilder.getHtmlLines());
    }

}