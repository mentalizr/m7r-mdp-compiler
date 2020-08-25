package org.mentalizr.mdpCompiler.attributeParser;

import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributeAlreadySpecifiedException;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributeNullOrEmptyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AttributeParserTest {

    @Test
    @DisplayName("Empty.")
    void emptyString() throws AttributeParserException {

        String educt = "";
        Attributes attributes = AttributeParser.parse(educt);

        assertEquals(0, attributes.getNrOfAttributes());
    }

    @Test
    @DisplayName("3 Assignments.")
    void threeAssignments() throws AttributeParserException {

        String educt = "name1=\"value\" myVar=\"dummy\" nochEineVar=\"true\"";
        Attributes attributes = AttributeParser.parse(educt);

        assertEquals(3, attributes.getNrOfAttributes());

        assertTrue(attributes.hasAttribute("name1"));
        assertEquals("value", attributes.getAttribute("name1").getValue());

        assertTrue(attributes.hasAttribute("myVar"));
        assertEquals("dummy", attributes.getAttribute("myVar").getValue());

        assertTrue(attributes.hasAttribute("nochEineVar"));
        assertEquals("true", attributes.getAttribute("nochEineVar").getValue());

    }

    @Test
    @DisplayName("3 simple attributes.")
    void threeSimpleAttributes() throws AttributeParserException {

        String educt = "\"Hallo\" \"dummy\" \"123\"";
        Attributes attributes = AttributeParser.parse(educt);

        assertEquals(3, attributes.getNrOfAttributes());

        assertTrue(attributes.hasAttribute("Hallo"));
        assertTrue(attributes.hasAttribute("dummy"));
        assertTrue(attributes.hasAttribute("123"));
    }

    @Test
    @DisplayName("Assignment with whitespace.")
    void assignmentWithWhitespace() throws AttributeParserException {

        String educt = " name1 = \"value\"";
        Attributes attributes = AttributeParser.parse(educt);

        assertEquals(1, attributes.getNrOfAttributes());

        assertTrue(attributes.hasAttribute("name1"));
        assertEquals("value", attributes.getValue("name1"));
    }

    @Test
    @DisplayName("Fail: Simple attribute without quotation mark.")
    void simpleAttributeWithoutQuotation() {

        String educt = "Hallo";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException e) {
            // Do intentionally nothing
        }
    }

    @Test
    @DisplayName("Fail: Simple attribute with missing quotation mark at begin.")
    void simpleAttributeMissingQuotationBegin() {

        String educt = "Hallo\"";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException e) {
            // Do intentionally nothing
        }
    }

    @Test
    @DisplayName("Fail: Simple attribute with missing quotation mark at end.")
    void simpleAttributeMissingQuotationEnd() {

        String educt = "\"Hallo";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException e) {
            // Do intentionally nothing
        }
    }

    @Test
    @DisplayName("Fail: Simple assignment with missing quotation marks.")
    void simpleAssignmentMissingQuotations() {

        String educt = "myVar=Hallo";
        try {
            AttributeParser.parse(educt);
            fail("Syntax-Fehler erwartet.");
        } catch (AttributeParserException e) {
            // Do intentionally nothing
        }
    }

    @Test
    @DisplayName("Fail: Simple assignment with missing quotations mark at begin.")
    void simpleAssignmentMissingQuotationBegin() {

        String educt = "myVar=Hallo\"";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException e) {
            // Do intentionally nothing
        }
    }

    @Test
    @DisplayName("Fail: Simple assignment with missing quotation marks at end.")
    void simpleAssignmentMissingQuotationAtEnd() {

        String educt = "myVar=\"Hallo";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException e) {
            // Do intentionally nothing
        }
    }

    @Test
    @DisplayName("Fail: Empty Attribute due to malformed attribute string.")
    void emptyAttributeDueToMalformation() {

        String educt = "id=\"4457\" name=\"worte\" \"\"Danke\" sagen\" \"einen Dankbrief oder eine Dankmail schreiben\"";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException attributeParserException) {
            Throwable cause = attributeParserException.getCause();
            assertTrue(cause instanceof AttributeNullOrEmptyException);
        }
    }

    @Test
    @DisplayName("Escaped attribute value.")
    void escapedAttributeValue() {

        String educt = "id=\"4457\" name=\"worte\" \"\\\"Danke\\\" sagen\"";
        try {
            Attributes attributes = AttributeParser.parse(educt);

            assertEquals(3, attributes.getNrOfAttributes());

            Set<String> attributesNameSet = attributes.getAttributeNameSet();
            for (String name : attributesNameSet) {
                System.out.println(name);
            }

            assertTrue(attributes.hasAttribute("\"Danke\" sagen"));


        } catch (AttributeParserException attributeParserException) {

            System.out.println(attributeParserException.getMessage());
            attributeParserException.printStackTrace();
        }
    }


    @Test
    @DisplayName("Fail: Double assignment of attribute.")
    void doubleAttributes() {

        String educt = "id=\"4457\" name=\"worte\" name=\"123\"";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException attributeParserException) {
            Throwable cause = attributeParserException.getCause();
            assertTrue(cause instanceof AttributeAlreadySpecifiedException);

            AttributeAlreadySpecifiedException attributeAlreadySpecifiedException = (AttributeAlreadySpecifiedException) cause;
            assertEquals("name", attributeAlreadySpecifiedException.getAttributeName());
        }
    }

    @Test
    @DisplayName("Fail: Token not recognizable as attribute string.")
    void tokenNotRecognizable() {

        String educt = "lorem ipsum dolor sit amet";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException attributeParserException) {
            assertTrue(attributeParserException instanceof TokenNotRecognizedException);
        }
    }

    @Test
    @DisplayName("Fail: No valid assingment. Equals sing missing.")
    void noValidAssignmentDueToNoEqualsSign() {

        String educt = "id\"4711\"";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException attributeParserException) {
            assertTrue(attributeParserException instanceof NoValidAssignmentException);
        }
    }

    @Test
    @DisplayName("Fail: No valid assingment. No attribute name.")
    void noValidAssignmentDueToNoAttributeName() {

        String educt = "=\"4711\"";
        try {
            AttributeParser.parse(educt);
            fail("Exception expected.");
        } catch (AttributeParserException attributeParserException) {
            assertTrue(attributeParserException instanceof NoValidAssignmentException);
        }
    }


}