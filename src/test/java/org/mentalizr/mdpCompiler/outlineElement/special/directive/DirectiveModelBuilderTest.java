package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectiveModelBuilderTest {

    @Test
    void plausibility() throws MDPSyntaxError {

        List<Line> lineList = Lines.create(Arrays.asList(
                "@@name=AutoTest1",
                "@@persistent"),
                1);

        DirectiveModelBuilder directiveModelBuilder = new DirectiveModelBuilder();
        DirectiveModel directiveModel = (DirectiveModel) directiveModelBuilder.getModel(new DirectiveExtraction(lineList));

        List<String> directiveList = directiveModel.getDirectives();

        assertEquals(2, directiveList.size());
        assertEquals("@@name=AutoTest1", directiveList.get(0));
        assertEquals("@@persistent", directiveList.get(1));
    }

    @Test
    void unrecognizedDirective() {

        List<Line> lineList = Lines.create(Arrays.asList(
                "@@unknownDirective"),
                1);

        DirectiveModelBuilder directiveModelBuilder = new DirectiveModelBuilder();
        try {
            directiveModelBuilder.getModel(new DirectiveExtraction(lineList));
            fail("Exception expected.");
        } catch (MDPSyntaxError mdpSyntaxError) {
            assertTrue(mdpSyntaxError instanceof UnrecognizedDirectiveException);
            UnrecognizedDirectiveException unrecognizedDirectiveException = (UnrecognizedDirectiveException) mdpSyntaxError;
            String directive = unrecognizedDirectiveException.getDirective();
            assertEquals("@@unknownDirective", directive);
        }
    }

    @Test
    void IllegalCombinationOfDirectives1() {

        List<Line> lineList = Lines.create(Arrays.asList(
                "@@persistent",
                "@@exercise"),
                1);

        DirectiveModelBuilder directiveModelBuilder = new DirectiveModelBuilder();
        try {
            directiveModelBuilder.getModel(new DirectiveExtraction(lineList));
            fail("Exception expected.");
        } catch (MDPSyntaxError mdpSyntaxError) {
            assertTrue(mdpSyntaxError instanceof IllegalCombinationOfDirectivesException);
            IllegalCombinationOfDirectivesException illegalCombinationOfDirectivesException = (IllegalCombinationOfDirectivesException) mdpSyntaxError;
            List<String> unknownDirectiveList = illegalCombinationOfDirectivesException.getDirectives();
            assertTrue(Strings.isOneOf("@@persistent", unknownDirectiveList.toArray(new String[0])));
            assertTrue(Strings.isOneOf("@@exercise", unknownDirectiveList.toArray(new String[0])));
        }
    }

    @Test
    void IllegalCombinationOfDirectives2() {

        List<Line> lineList = Lines.create(Arrays.asList(
                "@@feedback",
                "@@persistent"),
                1);

        DirectiveModelBuilder directiveModelBuilder = new DirectiveModelBuilder();
        try {
            directiveModelBuilder.getModel(new DirectiveExtraction(lineList));
            fail("Exception expected.");
        } catch (MDPSyntaxError mdpSyntaxError) {
            assertTrue(mdpSyntaxError instanceof IllegalCombinationOfDirectivesException);
            IllegalCombinationOfDirectivesException illegalCombinationOfDirectivesException = (IllegalCombinationOfDirectivesException) mdpSyntaxError;
            List<String> unknownDirectiveList = illegalCombinationOfDirectivesException.getDirectives();
            assertTrue(Strings.isOneOf("@@persistent", unknownDirectiveList.toArray(new String[0])));
            assertTrue(Strings.isOneOf("@@feedback", unknownDirectiveList.toArray(new String[0])));
        }
    }

}