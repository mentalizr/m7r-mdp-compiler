package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlertModelBuilderTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/alert/";

    @Test
    void getModel() throws IOException, MDPSyntaxError, AttributeProfileException {

        AttributesBuilder attributesBuilder = new AttributesBuilder()
                .addAttribute(AlertAttributes.ATTRIBUTE_NAME_TYPE, "info")
                .addAttribute(AlertAttributes.ATTRIBUTE_NAME_HEADERSIZE, "3");

        AlertAttributes alertAttributes = new AlertAttributes(attributesBuilder.build());
//        AlertAttributesParser alertAttributes = new AlertAttributesParser(AlertAttributes.ATTRIBUTE_NAME_TYPE + "=\"info\" " + AlertAttributes.ATTRIBUTE_NAME_HEADERSIZE + "=\"3\"");

        Document document = new Document(new File(EXPECTED_DIR, "extractor-plausi-1.expected"));
        Extraction extraction = new AlertExtraction(document);
//        List<Line> lines = document.getLines();

        AlertModelBuilder alertModelBuilder = new AlertModelBuilder(alertAttributes);
        AlertModel alertModel = alertModelBuilder.getModel(extraction);

        assertNotNull(alertModel);
        assertEquals("Hier der Info-Text!", alertModel.getText());
    }

}