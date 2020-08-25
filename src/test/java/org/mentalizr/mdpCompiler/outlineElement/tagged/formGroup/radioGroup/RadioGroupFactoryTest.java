package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class RadioGroupFactoryTest {

    @Test
    void isResponsible() {

        RadioGroupFactory radioGroupFactory = new RadioGroupFactory();
        Line line = Line.createLine0("@radio-group[name=\"myRadioGroup\" id=\"myRadioButton\" \"Situation\" \"Gedanken\" \"Gefühl\"]");

        assertTrue(radioGroupFactory.isResponsible(line));
    }

}