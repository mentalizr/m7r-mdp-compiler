package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import de.arthurpicht.utils.io.textfile.TextFile;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.mdpTag.MDPTagSimple;
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
    void render() throws MDPSyntaxError, IOException {

        Result result = new ResultTest();

        AlertModel alertModel = new AlertModel();
        MDPTag mdpTag = new MDPTagSimple(new Alert(), new Line("@alert[type=\"info\" headersize=\"3\"]", 0));
        alertModel.setMdpTag(mdpTag);
        alertModel.setText("Hier der Info-Text!");

        AlertRenderer alertRenderer = new AlertRenderer();
        alertRenderer.render(alertModel, CompilerContext.getDefaultTestContext(), result);

        List<String> expectedLines = TextFile.getLinesAsStrings(new File(EXPECTED_DIR, "plausi_pos_1.expected"));

        assertEquals(expectedLines, result.getResultLines());
    }

    // TODO Test ohne optionales Attribut headersize

}