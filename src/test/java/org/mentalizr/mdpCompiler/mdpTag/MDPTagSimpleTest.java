package org.mentalizr.mdpCompiler.mdpTag;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MDPTagSimpleTest {

    @Test
    @DisplayName("standard")
    void standard() throws MDPSyntaxError {

        Line educt = Line.createLine0("@radiogroup[name=\"myRadioGroup\", id=\"myRadioButton\", \"Situation\", \"Gedanken\", \"Gefühl\"]");

        MDPTagSimple mdpTagSimple = new MDPTagSimple("radiogroup", educt);
        String attributesString = mdpTagSimple.getAttributeString();
        assertEquals("name=\"myRadioGroup\", id=\"myRadioButton\", \"Situation\", \"Gedanken\", \"Gefühl\"", attributesString);
    }

    @Test
    @DisplayName("Leerzeichen nach eckiger Klammer")
    void leerzeichenNachEckigerKlammer() throws MDPSyntaxError {

        Line educt = Line.createLine0("@radiogroup[ name=\"myRadioGroup\", id=\"myRadioButton\", \"Situation\", \"Gedanken\", \"Gefühl\" ]");

        MDPTagSimple mdpTagSimple = new MDPTagSimple("radiogroup", educt);
        String attributesString = mdpTagSimple.getAttributeString();
        assertEquals("name=\"myRadioGroup\", id=\"myRadioButton\", \"Situation\", \"Gedanken\", \"Gefühl\"", attributesString);
    }

    @Test
    @DisplayName("Whitespace am Anfang und Ende")
    void whitespaceAmAnfangUndEnde() throws MDPSyntaxError {

        Line educt = Line.createLine0(" @radiogroup[name=\"myRadioGroup\", id=\"myRadioButton\", \"Situation\", \"Gedanken\", \"Gefühl\"] ");

        MDPTagSimple mdpTagSimple = new MDPTagSimple("radiogroup", educt);
        String attributesString = mdpTagSimple.getAttributeString();
        assertEquals("name=\"myRadioGroup\", id=\"myRadioButton\", \"Situation\", \"Gedanken\", \"Gefühl\"", attributesString);
    }

}