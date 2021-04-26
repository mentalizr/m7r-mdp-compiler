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


    @Test
    void getModel() throws MDPSyntaxError {

        Document document = new Document(
                "@alert[type=\"info\" headersize=\"3\"]",
                "    Hier der Info-Text!"
        );
        Extraction extraction = new AlertExtraction(document);

        AlertModelBuilder alertModelBuilder = new AlertModelBuilder();
        AlertModel alertModel = alertModelBuilder.getModel(extraction);

        assertNotNull(alertModel);
        assertEquals("Hier der Info-Text!", alertModel.getText());

        AlertAttributes alertAttributes = alertModel.getAlertAttributes();
        assertEquals("info", alertAttributes.getType());
        assertEquals("3", alertAttributes.getHeadersize());
    }

}