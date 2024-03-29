package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import de.arthurpicht.utils.io.textfile.TextFile;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ULRendererTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/md/ul/";

    @Test
    void render() throws IOException {

        HtmlBuilder htmlBuilder = new HtmlBuilder();
        ULModel ulModel = new ULModel();
        ulModel.addItem("first Item");
        ulModel.addItem("second Item");
        ulModel.addItem("third Item");

        ULRenderer ulRenderer = new ULRenderer();
        ulRenderer.render(ulModel, CompilerContext.getDefaultTestContext(), htmlBuilder);

        for (String string : htmlBuilder.getHtmlLines()) {
            System.out.println(string);
        }

        List<String> expectedLines = TextFile.getLinesAsStrings(new File(EXPECTED_DIR, "plausi-1.expected"));
        assertEquals(expectedLines, htmlBuilder.getHtmlLines());
    }

}