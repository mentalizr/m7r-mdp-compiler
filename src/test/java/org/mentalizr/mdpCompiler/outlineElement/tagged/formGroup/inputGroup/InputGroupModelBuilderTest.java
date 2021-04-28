package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.md.heading.HeadingModel;
import org.mentalizr.mdpCompiler.outlineElement.md.paragraph.ParagraphModel;
import org.mentalizr.mdpCompiler.outlineElement.md.ul.ULModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputGroupModelBuilderTest {

    @Test
    void getModel() throws MDPSyntaxError {

        Extraction inputGroupExtraction = new InputGroupExtraction(Lines.create(
                "@input-group[id=\"0815-2\"]",
                "    * erster",
                "    * zweiter",
                "    * dritter",
                "",
                "    ### Eine Überschrift H3",
                "",
                "    ## Eine Überschrift H2",
                "",
                "    # Eine Überschrift H1",
                "",
                "    Hier noch ein Paragraph"
        ));

        InputGroupModel inputGroupModel = new InputGroupModelBuilder().getModel(inputGroupExtraction);

        InputGroupAttributes attributes = inputGroupModel.getInputGroupAttributes();
        assertEquals("0815-2", attributes.getId());

        assertTrue(inputGroupModel.hasChildModels());
        assertFalse(inputGroupModel.hasSingleLine());

        List<OutlineElementModel> childModels = inputGroupModel.getChildModels();
        assertEquals(5, childModels.size());

        OutlineElementModel childModel1 = childModels.get(0);
        assertTrue(childModel1 instanceof ULModel);

        OutlineElementModel childModel2 = childModels.get(1);
        assertTrue(childModel2 instanceof HeadingModel);
        HeadingModel headingModelChild2 = (HeadingModel) childModel2;
        assertEquals(3, headingModelChild2.getHeadingLevel());
        assertEquals("Eine Überschrift H3", headingModelChild2.getHeading());

        OutlineElementModel childModel3 = childModels.get(2);
        assertTrue(childModel3 instanceof HeadingModel);
        HeadingModel headingModelChild3 = (HeadingModel) childModel3;
        assertEquals(2, headingModelChild3.getHeadingLevel());
        assertEquals("Eine Überschrift H2", headingModelChild3.getHeading());

        OutlineElementModel childModel4 = childModels.get(3);
        assertTrue(childModel4 instanceof HeadingModel);
        HeadingModel headingModelChild4 = (HeadingModel) childModel4;
        assertEquals(1, headingModelChild4.getHeadingLevel());
        assertEquals("Eine Überschrift H1", headingModelChild4.getHeading());

        OutlineElementModel childModel5 = childModels.get(4);
        assertTrue(childModel5 instanceof ParagraphModel);
        ParagraphModel paragraphModel = (ParagraphModel) childModel5;
        assertEquals(1, paragraphModel.getTextLines().size());
        assertEquals("Hier noch ein Paragraph", paragraphModel.getTextLines().get(0));
    }

}