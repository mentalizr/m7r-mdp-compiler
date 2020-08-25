package org.mentalizr.mdpCompiler._integration;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.IntegrationTestBench;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class DocumentWithOneMDPElement {

    private static final String RESRC_DIR = "src/test/resrc/integration/";

    @Test
    void alertDocument() throws IOException, MDPSyntaxError {

        IntegrationTestBench.execute(
                new File(RESRC_DIR, "alert-document.mdp"),
                new File(RESRC_DIR, "alert-document.expected"));
    }

    @Test
    void radioGroupDocument() throws IOException, MDPSyntaxError {

        IntegrationTestBench.execute(
                new File(RESRC_DIR, "radioGroup-document.mdp"),
                new File(RESRC_DIR, "radioGroup-document.expected"));
    }

}