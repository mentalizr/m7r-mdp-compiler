package org.mentalizr.mdpCompiler.attributeParser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttributeExtractorTest {

    @Test
    @DisplayName("assignment")
    void assignment() throws AttributeParserException {

        String educt = "name=\"myRadioGroup\" id=\"myRadioButton\" \"Situation\" \"Gedanken\" \"Gefühl\"";
        AttributeExtractor attributeExtractor = new AttributeExtractor(educt);

        assertTrue(attributeExtractor.isAssignment());
        assertTrue(attributeExtractor.hasName());
        assertEquals("name", attributeExtractor.getName());
        assertTrue(attributeExtractor.hasValue());
        assertEquals("myRadioGroup", attributeExtractor.getValue());
        assertEquals("id=\"myRadioButton\" \"Situation\" \"Gedanken\" \"Gefühl\"", attributeExtractor.getShortenedEductString());
    }

    @Test
    @DisplayName("assignment with whitespace")
    void assignmentWithWhitespace() throws AttributeParserException {

        String educt = "   name   =   \"myRadioGroup\" id=\"myRadioButton\" \"Situation\" \"Gedanken\" \"Gefühl\"";
        AttributeExtractor attributeExtractor = new AttributeExtractor(educt);

        assertTrue(attributeExtractor.isAssignment());
        assertTrue(attributeExtractor.hasName());
        assertEquals("name", attributeExtractor.getName());
        assertTrue(attributeExtractor.hasValue());
        assertEquals("myRadioGroup", attributeExtractor.getValue());
        assertEquals("id=\"myRadioButton\" \"Situation\" \"Gedanken\" \"Gefühl\"", attributeExtractor.getShortenedEductString());
    }

    @Test
    @DisplayName("value without assignment")
    void valueWithoutAssignment() throws AttributeParserException {

        String educt = "  \"myRadioGroup\" id=\"myRadioButton\" \"Situation\" \"Gedanken\" \"Gefühl\"";
        AttributeExtractor attributeExtractor = new AttributeExtractor(educt);

        assertFalse(attributeExtractor.isAssignment());
        assertFalse(attributeExtractor.hasName());
        assertTrue(attributeExtractor.hasValue());
        assertEquals("myRadioGroup", attributeExtractor.getValue());
        assertEquals("id=\"myRadioButton\" \"Situation\" \"Gedanken\" \"Gefühl\"", attributeExtractor.getShortenedEductString());
    }

    @Test
    @DisplayName("value without assignment, edge case")
    void valueWithoutAssignmentEdge() throws AttributeParserException {

        String educt = "\"myRadioGroup\"";
        AttributeExtractor attributeExtractor = new AttributeExtractor(educt);

        assertFalse(attributeExtractor.isAssignment());
        assertFalse(attributeExtractor.hasName());
        assertTrue(attributeExtractor.hasValue());
        assertEquals("myRadioGroup", attributeExtractor.getValue());
        assertEquals("", attributeExtractor.getShortenedEductString());
    }

    @Test
    @DisplayName("fail: no value")
    void failNoValue() {

        String educt = "myRadioGroup\"";
        AttributeExtractor attributeExtractor = null;
        try {
            attributeExtractor = new AttributeExtractor(educt);
            fail("Exception expected.");
        } catch (AttributeParserException mdpSyntaxError) {
            // do intentionally nothing
        }
    }

    @Test
    @DisplayName("fail: wrong assignment")
    void failWrongAssignment() {

        String educt = "asdfd\"myRadioGroup\"";
        AttributeExtractor attributeExtractor = null;
        try {
            attributeExtractor = new AttributeExtractor(educt);
            fail("Exception expected.");
        } catch (AttributeParserException mdpSyntaxError) {
            // do intentionally nothing
        }
    }

    @Test
    @DisplayName("fail: wrong assignment2")
    void failWrongAssignment2() {

        String educt = "=\"myRadioGroup\"";
        AttributeExtractor attributeExtractor = null;
        try {
            attributeExtractor = new AttributeExtractor(educt);
            fail("Exception expected.");
        } catch (AttributeParserException mdpSyntaxError) {
            // do intentionally nothing
        }
    }

}