package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class MCQuestionModelBuilderTest {

    @Test
    void buildModel() throws MDPSyntaxError, AttributeParserException, AttributeProfileException {

        MCQuestionAttributesParser mcQuestionAttributesParser = new MCQuestionAttributesParser("");
        MCQuestionAttributes mcQuestionAttributes = mcQuestionAttributesParser.getOutlineElementTaggedAttributes();

        Document document = new Document(
                "@mc-question[]",
                "    Frage 1 von 5",
                "    Welche zwei Arten von Stressbewältigung unterscheidet der Stressforscher Richard Lazarus in seinem berühmten transaktionalen Stressmodell?",
                "    - Veränderungszentriert und Vermeidungszentriert",
                "    + Problemorientiert und Emotionsorientiert",
                "    - Ablenkungsfokussiert und Emotionsfokussiert",
                "    - Vermeidungsfokussiert und Problemfokussiert"

                );
//        List<Line> lines = document.getLines();
        Extraction extraction = new McQuestionExtraction(document);

        MCQuestionModelBuilder mcQuestionModelBuilder = new MCQuestionModelBuilder();
        MCQuestionModel mcQuestionModel = mcQuestionModelBuilder.getModel(extraction);

        assertEquals(MCQuestionModel.MCQuestionType.ONE, mcQuestionModel.getMcQuestionType());

        assertTrue(mcQuestionModel.hasTitle());
        assertEquals("Frage 1 von 5", mcQuestionModel.getTitle());
        assertEquals("Welche zwei Arten von Stressbewältigung unterscheidet der Stressforscher Richard Lazarus in seinem berühmten transaktionalen Stressmodell?", mcQuestionModel.getQuestion());

        List<MCQuestionAnsweringOption> mcQuestionAnsweringOptionList = mcQuestionModel.getMcQuestionAnsweringOptions();
        assertEquals(4, mcQuestionAnsweringOptionList.size());

        MCQuestionAnsweringOption mcQuestionAnsweringOption1 = mcQuestionAnsweringOptionList.get(0);
        assertFalse(mcQuestionAnsweringOption1.isCorrect());
        assertEquals("Veränderungszentriert und Vermeidungszentriert", mcQuestionAnsweringOption1.getText());

        MCQuestionAnsweringOption mcQuestionAnsweringOption2 = mcQuestionAnsweringOptionList.get(1);
        assertTrue(mcQuestionAnsweringOption2.isCorrect());
        assertEquals("Problemorientiert und Emotionsorientiert", mcQuestionAnsweringOption2.getText());

        MCQuestionAnsweringOption mcQuestionAnsweringOption3 = mcQuestionAnsweringOptionList.get(2);
        assertFalse(mcQuestionAnsweringOption3.isCorrect());
        assertEquals("Ablenkungsfokussiert und Emotionsfokussiert", mcQuestionAnsweringOption3.getText());

        MCQuestionAnsweringOption mcQuestionAnsweringOption4 = mcQuestionAnsweringOptionList.get(3);
        assertFalse(mcQuestionAnsweringOption4.isCorrect());
        assertEquals("Vermeidungsfokussiert und Problemfokussiert", mcQuestionAnsweringOption4.getText());
    }


}