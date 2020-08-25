package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ULModelBuilderTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/md/ul/";

    @Test
    void getModel() throws IOException {

        Document document = new Document(new File(EXPECTED_DIR, "ul-1.mdp"));
        List<Line> lines = document.getLines();

        ULModelBuilder ulModelBuilder = new ULModelBuilder(lines);
        ULModel ulModel = ulModelBuilder.getModel();

        assertNotNull(ulModel);

        List<String> itemList = ulModel.getItemList();

        assertEquals(4, itemList.size());
        assertEquals("first item", itemList.get(0));
        assertEquals("second item", itemList.get(1));
        assertEquals("third item", itemList.get(2));
        assertEquals("forth item", itemList.get(3));
    }

}