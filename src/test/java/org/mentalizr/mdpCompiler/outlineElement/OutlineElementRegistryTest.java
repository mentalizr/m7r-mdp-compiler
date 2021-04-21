package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.md.heading.H3;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroup;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class OutlineElementRegistryTest {

    @Test
    void getMatchingElementH3() throws MDPSyntaxError {

        List<String> listOfLines = Collections.singletonList("### Einführung");
        Document document = new Document(0, listOfLines);
        DocumentIterator documentIterator = document.getDocumentIterator();

        ResultTest resultTest = new ResultTest();
        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry();

        OutlineElement element = outlineElementRegistry.getMatchingElement(documentIterator.getNextLine(), MDPCompiler.Mode.MDP_COMPLETE);

        if (!(element instanceof H3)) {
            fail("OutlineElement vom Typ H3 erwartet.");
        }
    }

    @Test
    void getMatchingElementRadioGroup() throws MDPSyntaxError {

        List<String> listOfLines = Collections.singletonList("@radio-group[id=\"myId\" name=\"myName\" \"Situation\" \"Gedanken\" \"Gefühl\"]");
        Document document = new Document(0, listOfLines);
        DocumentIterator documentIterator = document.getDocumentIterator();

        ResultTest resultTest = new ResultTest();
        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry();
//        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry(resultTest, documentIterator);

        OutlineElement element = outlineElementRegistry.getMatchingElement(documentIterator.getNextLine(), MDPCompiler.Mode.MDP_COMPLETE);

        if (!(element instanceof RadioGroup)) {
            System.out.println(element.getClass().getCanonicalName());
            fail("OutlineElement vom Typ RadioGroup erwartet.");
        }
    }

}