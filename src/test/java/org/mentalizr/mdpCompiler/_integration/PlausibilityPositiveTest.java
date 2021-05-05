package org.mentalizr.mdpCompiler._integration;

import org.mentalizr.mdpCompiler.Dom;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompilerTestResrc.IntegrationTestBench;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PlausibilityPositiveTest {

    private static final String EXPECTED_DIR = "src/test/resrc/integration/";

    @Test
    void test1() throws IOException {

        try {

            IntegrationTestBench.execute(
                    new File(EXPECTED_DIR, "test1.mdp"),
                    new File(EXPECTED_DIR, "test1.expected")
            );

        } catch (MDPSyntaxError e) {
            System.out.println(MDPSyntaxError.class.getSimpleName() + " in Zeile " + + e.getLine().getLineNr() + ": " + e.getMessage());
            fail(e.getMessage(), e);
        }

    }

    @Test
    void md1_mediaResources() throws IOException, MDPSyntaxError {
        Document document = new Document(new File(EXPECTED_DIR, "test1.mdp"));
        Dom dom = MDPCompiler.createDom(document);
        Set<String> mediaResources = dom.getReferencedMediaResources();

        assertEquals(Set.of("joe_400x250.jpg"), mediaResources);
    }

}