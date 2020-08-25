package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import de.arthurpicht.utils.io.textfile.TextFile;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ULRendererTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/md/ul/";

    @Test
    void render() throws IOException {

        Result result = new ResultTest();
        ULModel ulModel = new ULModel();
        ulModel.addItem("first Item");
        ulModel.addItem("second Item");
        ulModel.addItem("third Item");

        ULRenderer ulRenderer = new ULRenderer(result, ulModel);
        ulRenderer.render(CompilerContext.getDefaultTestContext());

        for (String string : result.getResultLines()) {
            System.out.println(string);
        }

        List<String> expectedLines = TextFile.getLinesAsStrings(new File(EXPECTED_DIR, "plausi-1.expected"));
        assertEquals(expectedLines, result.getResultLines());
    }

}