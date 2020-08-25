package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class ImgFluidAttributesParserTest {

    @Test
    void plausibilityTest() throws AttributeParserException, AttributeProfileException {

        String attributeString = "alt=\"Ein alternativer Text\"";

        ImgFluidAttributesParser imgFluidAttributesParser = new ImgFluidAttributesParser(attributeString);
        ImgFluidAttributes imgFluidAttributes = imgFluidAttributesParser.getOutlineElementTaggedAttributes();

        assertEquals("Ein alternativer Text", imgFluidAttributes.getAlt());
        assertEquals("0", imgFluidAttributes.getMarginTop());
        assertEquals("0", imgFluidAttributes.getNameMarginBottom());
    }

    @Test
    void marginTest() throws AttributeParserException, AttributeProfileException {

        String attributeString = "alt=\"Ein alternativer Text\" margin-bottom=\"2\" margin-top=\"3\"";

        ImgFluidAttributesParser imgFluidAttributesParser = new ImgFluidAttributesParser(attributeString);
        ImgFluidAttributes imgFluidAttributes = imgFluidAttributesParser.getOutlineElementTaggedAttributes();

        assertEquals("Ein alternativer Text", imgFluidAttributes.getAlt());
        assertEquals("2", imgFluidAttributes.getNameMarginBottom());
        assertEquals("3", imgFluidAttributes.getMarginTop());
    }

}