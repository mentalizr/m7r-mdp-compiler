package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

@SuppressWarnings("SpellCheckingInspection")
class InputGroupTest {

    private static final String RESRC_DIR = "src/test/resrc/outlineElement/tagged/formGroup/inputGroup";

    @Test
    void plausibility1() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new InputGroupFactory(),
                new String[]{
                        "@input-group[id=\"input_myId\"]",
                        "    Eine Überschrift in *kursiv*.",
                        "",
                        "Hier noch was anderes"
                },
                new String[]{
                        "<div class=\"form-group\">",
                        "    <label for=\"input_myId\">Eine Überschrift in <em>kursiv</em>.</label>",
                        "    <input type=\"text\" class=\"form-control ns_input\" id=\"input_myId\" placeholder=\"\">",
                        "</div>"
                },
                2
        );
    }

    @Test
    void plausibilityMD() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor =
                new OutlineElementTestBenchExecutor(new InputGroupFactory())
                        .withMDPFile(new File(RESRC_DIR, "input-group_md_ul.mdp"))
                        .withExpectedFile(new File(RESRC_DIR, "input-group_md_ul.expected"))
                        .withExpectedDocumentIteratorIndex(8);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void scopeId() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new InputGroupFactory(),
                new String[]{
                        "@input-group[id=\"input_myId\" scope=\"program\" scope-id=\"input_myScopeId\"]",
                        "    Eine Überschrift in *kursiv*.",
                        "",
                        "Hier noch was anderes"
                },
                new String[]{
                        "<div class=\"form-group\">",
                        "    <label for=\"input_myId\">Eine Überschrift in <em>kursiv</em>.</label>",
                        "    <input type=\"text\" class=\"form-control ns_input\" id=\"input_myId\" data-m7r-program-scope-id=\"input_myScopeId\" placeholder=\"\">",
                        "</div>"
                },
                2
        );
    }

    @Test
    @DisplayName("scope-id in page scope: ignore scope-id")
    void scopeIdInPageScope() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new InputGroupFactory(),
                new String[]{
                        "@input-group[id=\"input_myId\" scope-id=\"input_myScopeId\"]",
                        "    Eine Überschrift in *kursiv*.",
                        "",
                        "Hier noch was anderes"
                },
                new String[]{
                        "<div class=\"form-group\">",
                        "    <label for=\"input_myId\">Eine Überschrift in <em>kursiv</em>.</label>",
                        "    <input type=\"text\" class=\"form-control ns_input\" id=\"input_myId\" placeholder=\"\">",
                        "</div>"
                },
                2
        );
    }

}