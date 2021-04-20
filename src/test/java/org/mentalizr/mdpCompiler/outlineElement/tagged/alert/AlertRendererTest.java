package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import de.arthurpicht.utils.io.textfile.TextFile;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlertRendererTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/alert/";

    @Test
    void render() throws MDPSyntaxError, IOException, AttributeProfileException {

        Result result = new ResultTest();
        AttributesBuilder attributesBuilder = new AttributesBuilder()
                .addAttribute(AlertAttributes.ATTRIBUTE_NAME_TYPE, "info")
                .addAttribute(AlertAttributes.ATTRIBUTE_NAME_HEADERSIZE, "3");
        AlertAttributes alertAttributes = new AlertAttributes(attributesBuilder.build());

//        AlertAttributesParser alertAttributes = new AlertAttributesParser(AlertAttributes.ATTRIBUTE_NAME_TYPE + "=\"info\" " + AlertAttributes.ATTRIBUTE_NAME_HEADERSIZE + "=\"3\"");

        AlertModel alertModel = new AlertModel();
        alertModel.setText("Hier der Info-Text!");

        AlertRenderer alertRenderer = new AlertRenderer(alertAttributes, alertModel);
        alertRenderer.render(CompilerContext.getDefaultTestContext(), result);

        for (String htmlLine : result.getResultLines()) {
            System.out.println(htmlLine);
        }

        List<String> expectedLines = TextFile.getLinesAsStrings(new File(EXPECTED_DIR, "plausi_pos_1.expected"));

        assertEquals(expectedLines, result.getResultLines());
    }

    // TODO Test ohne optionales Attribut headersize

}