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

public class PlausibilityMDPositiveTest {

    private static final String RESRC_DIR = "src/test/resrc/integration/";

    @Test
    void md1() throws IOException, MDPSyntaxError {

        IntegrationTestBench.execute(
                new File(RESRC_DIR, "test_md_1.mdp"),
                new File(RESRC_DIR, "test_md_1.expected"));

    }

}
