package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;
import org.junit.jupiter.api.Test;

import java.io.File;

@SuppressWarnings("SpellCheckingInspection")
class TextareaGroupTest {

    private static final String EXPECTED_DIR = "src/test/resrc/outlineElement/tagged/formGroup/textareaGroup";

    @Test
    void plausibility1() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new TextareaGroupFactory())
                .withMDPLines(
                        "@textarea-group[id=\"input_myId\" rows=\"2\"]",
                        "    Eine Überschrift.",
                        "",
                        "Hier noch was anderes"
                )
                .withExpectedFile(new File(EXPECTED_DIR, "textarea-basic-1.expected"))
                .withExpectedDocumentIteratorIndex(2);

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

    @Test
    void scopeId() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new TextareaGroupFactory(),
                new String[]{
                        "@textarea-group[id=\"input_myId\" scope=\"program\" scope-id=\"input_myScopeId\"]",
                        "    Eine Überschrift in *kursiv*.",
                        "",
                        "Hier noch was anderes"
                },
                new String[]{
                        "<div class=\"form-group\">",
                        "    <label for=\"input_myId\">Eine Überschrift in <em>kursiv</em>.</label>",
                        "    <textarea class=\"form-control ns_input\" id=\"input_myId\" data-m7r-program-scope-id=\"input_myScopeId\" rows=\"3\"></textarea>",
                        "</div>"
                },
                2
        );
    }

    @Test
    void scopeIdInPageScope() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new TextareaGroupFactory(),
                new String[]{
                        "@textarea-group[id=\"input_myId\" scope-id=\"input_myScopeId\"]",
                        "    Eine Überschrift in *kursiv*.",
                        "",
                        "Hier noch was anderes"
                },
                new String[]{
                        "<div class=\"form-group\">",
                        "    <label for=\"input_myId\">Eine Überschrift in <em>kursiv</em>.</label>",
                        "    <textarea class=\"form-control ns_input\" id=\"input_myId\" rows=\"3\"></textarea>",
                        "</div>"
                },
                2
        );
    }

    @Test
    void readonly() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new TextareaGroupFactory(),
                new String[]{
                        "@textarea-group[id=\"input_myId\" readonly=\"true\"]",
                        "    Eine Überschrift in *kursiv*.",
                        "",
                        "Hier noch was anderes"
                },
                new String[]{
                        "<div class=\"form-group\">",
                        "    <label for=\"input_myId\">Eine Überschrift in <em>kursiv</em>.</label>",
                        "    <textarea class=\"form-control ns_input\" id=\"input_myId\" rows=\"3\" disabled></textarea>",
                        "</div>"
                },
                2
        );

    }

    @Test
    void refId() throws MDPSyntaxError {

        OutlineElementTestBench.execute(
                new TextareaGroupFactory(),
                new String[]{
                        "@textarea-group[id=\"input_myId\" ref-id=\"myRefId\"]",
                        "    Eine Überschrift in *kursiv*.",
                        "",
                        "Hier noch was anderes"
                },
                new String[]{
                        "<div class=\"form-group\">",
                        "    <label for=\"input_myId\">Eine Überschrift in <em>kursiv</em>.</label>",
                        "    <textarea class=\"form-control ns_input\" id=\"input_myId\" data-m7r-ref-id=\"myRefId\" rows=\"3\"></textarea>",
                        "</div>"
                },
                2
        );
    }

}