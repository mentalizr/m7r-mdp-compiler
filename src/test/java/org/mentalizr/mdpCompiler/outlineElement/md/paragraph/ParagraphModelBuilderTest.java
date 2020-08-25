package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParagraphModelBuilderTest {

    @Test
    @DisplayName("Plausibility positive")
    void plausi() throws MDPSyntaxError {

        List<Line> mdpLines = Arrays.asList(new Line("Ein Absatz", 0));

        ParagraphModelBuilder paragraphModelBuilder = new ParagraphModelBuilder(mdpLines);
        ParagraphModel paragraphModel = paragraphModelBuilder.getModel();
        List<String> contentLines = paragraphModel.getTextLines();

        assertNotNull(contentLines);
        assertEquals(1, contentLines.size());
        assertEquals("Ein Absatz", contentLines.get(0));
    }

}