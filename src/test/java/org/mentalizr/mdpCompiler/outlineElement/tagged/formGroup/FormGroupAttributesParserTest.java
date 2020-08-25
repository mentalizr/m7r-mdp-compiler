package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormGroupAttributesParserTest {

    private FormGroupAttributesTestImpl getFormGroupAttributes(String attributeString) throws AttributeParserException, AttributeProfileException {

        FormGroupAttributesParserTestImpl formGroupAttributesParser
                = new FormGroupAttributesParserTestImpl(attributeString);

        return (FormGroupAttributesTestImpl) formGroupAttributesParser.getOutlineElementTaggedAttributes();
    }

    @Test
    void illegalDotInIdValue() {

        String attributeString = "id=\"1.1\"";

        try {
            new FormGroupAttributesParserTestImpl(attributeString);

            fail("Exception expected: Illegal dot in id value.");

        } catch (AttributeParserException | AttributeProfileException mdpSyntaxError) {
            //din
        }
    }

    @Test
    void idAttributeMissing() {

        String attributeString = "";

        try {
            new FormGroupAttributesParserTestImpl(attributeString);

            fail("Exception expected: missing id attribute.");

        } catch (AttributeParserException | AttributeProfileException mdpSyntaxError) {
            //din
        }
    }

    @Test
    void refId() throws AttributeParserException, AttributeProfileException {

        String attributeString = "id=\"myId\"";
        FormGroupAttributesTestImpl formGroupAttributes = getFormGroupAttributes(attributeString);

        assertFalse(formGroupAttributes.hasRefId());
    }

    @Test
    void refIdSpecified() throws AttributeParserException, AttributeProfileException {

        String attributeString = "id=\"myId\" ref-id=\"myRefId\"";
        FormGroupAttributesTestImpl formGroupAttributes = getFormGroupAttributes(attributeString);

        assertTrue(formGroupAttributes.hasRefId());
        assertEquals("myRefId", formGroupAttributes.getRefId());
    }


    @Test
    void defaultReadonly() throws AttributeParserException, AttributeProfileException {

        String attributeString = "id=\"myId\"";
        FormGroupAttributesTestImpl formGroupAttributes = getFormGroupAttributes(attributeString);

        assertFalse(formGroupAttributes.isReadonly());
    }

    @Test
    void specifiedReadonly() throws AttributeParserException, AttributeProfileException {

        String attributeString = "id=\"myId\" readonly=\"true\"";
        FormGroupAttributesTestImpl formGroupAttributes = getFormGroupAttributes(attributeString);

        assertTrue(formGroupAttributes.isReadonly());
    }

}