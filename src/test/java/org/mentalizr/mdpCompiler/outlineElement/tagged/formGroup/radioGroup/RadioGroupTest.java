package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
class RadioGroupTest {

    private static final String TEST_RESRC_DIR = "src/test/resrc/outlineElement/tagged/formGroup/radioGroup";

    @Test
    void plausibility1() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new RadioGroupFactory(),
                new String[]{
                        "@radio-group[id=\"input_myId\" name=\"myName\" \"Label1\" \"Label2\" \"Label3\"]",
                        "    This is a headline",
                        "",
                        "Something completely different."
                },
                new File(TEST_RESRC_DIR, "radiogroup-plausi_1.expected"),
                2
        );
    }

    @Test
    void plausibilityMD() throws MDPSyntaxError, IOException {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new RadioGroupFactory())
                .withMDPFile(new File(TEST_RESRC_DIR, "radiogroup_md_ul.mdp"))
                .withExpectedFile(new File(TEST_RESRC_DIR, "radiogroup_md_ul.expected"))
                .withExpectedDocumentIteratorIndex(4);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    // TODO Test für MD in label, falls das in HTML funktioniert

    @Test
    void escapedAttributeValue() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new RadioGroupFactory(),
                new String[]{
                        "@radio-group[id=\"4457\" name=\"worte\" \"\\\"Danke\\\" sagen\" \"einen Dankbrief oder eine Dankmail schreiben\"]",
                        "    This is a headline",
                        "",
                        "Something completely different."
                },
                new File(TEST_RESRC_DIR, "radiogroup-escaped.expected"),
                2
        );
    }

    @Test
    void scopeId() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new RadioGroupFactory(),
                new String[]{
                        "@radio-group[id=\"input_myId\" name=\"myName\" scope=\"program\" scope-id=\"myScopeId\" \"Label1\" \"Label2\" \"Label3\"]",
                        "    This is a headline",
                        "",
                        "Something completely different."
                },
                new File(TEST_RESRC_DIR, "radiogroup-scope-program-1.expected"),
                2
        );
    }

    @Test
    @DisplayName("scope-id used in page scope: ignore")
    void scopeIdInScopePage() throws MDPSyntaxError, IOException {

        OutlineElementTestBench.execute(
                new RadioGroupFactory(),
                new String[]{
                        "@radio-group[id=\"input_myId\" name=\"myName\" scope-id=\"myScopeId\" \"Label1\" \"Label2\" \"Label3\"]",
                        "    This is a headline",
                        "",
                        "Something completely different."
                },
                new File(TEST_RESRC_DIR, "radiogroup-plausi_1.expected"),
                2
        );
    }

    @Test
    void readonly() throws IOException, MDPSyntaxError {

        OutlineElementTestBench.execute(
                new RadioGroupFactory(),
                new String[]{
                        "@radio-group[id=\"input_myId\" name=\"myName\" readonly=\"true\" scope-id=\"myScopeId\" \"Label1\" \"Label2\" \"Label3\"]",
                        "    This is a headline",
                        "",
                        "Something completely different."
                },
                new File(TEST_RESRC_DIR, "radiogroup-readonly.expected"),
                2
        );
    }

    @Test
    void refId() throws IOException, MDPSyntaxError {

        OutlineElementTestBench.execute(
                new RadioGroupFactory(),
                new String[]{
                        "@radio-group[id=\"input_myId\" name=\"myName\" ref-id=\"myRefId\" scope-id=\"myScopeId\" \"Label1\" \"Label2\" \"Label3\"]",
                        "    This is a headline",
                        "",
                        "Something completely different."
                },
                new File(TEST_RESRC_DIR, "radiogroup-refid.expected"),
                2
        );
    }

}

