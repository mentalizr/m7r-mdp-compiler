package org.mentalizr.mdpCompiler.attributeParser;

import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.Attributes;
import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;

/**
 * Parst einen String in Name/Wert-Paare.
 *
 * Sie TestCases als Bsp.
 *
 * Limitationen: Die Zeichen "," (Komma), "=" (gleich) und " (Anführungszeichen) dürfen nicht
 * Bestandteil einer Variablenbezeichnung oder einer Wertdefinition sein.
 *
 */
public class AttributeParser {

    public static Attributes parse(String attributesString) throws AttributeParserException {

        AttributesBuilder attributesBuilder = new AttributesBuilder();

        while(!attributesString.equals("")) {

            try {
                attributesString = processNextChunkOfAttributeString(attributesBuilder, attributesString);
            } catch (AttributeProfileException e) {
                throw new AttributeParserException("Malformed attribute specification. " + e.getMessage(), e);
            }

        }

        return attributesBuilder.build();
    }

    private static String processNextChunkOfAttributeString(AttributesBuilder attributesBuilder, String attributesString) throws AttributeParserException, AttributeProfileException {

        AttributeExtractor attributeExtractor = new AttributeExtractor(attributesString);
        String value = attributeExtractor.getValue();
        if (attributeExtractor.isAssignment()) {
            String name = attributeExtractor.getName();
            attributesBuilder.addAttribute(name, value);
        } else {
            attributesBuilder.addSimpleAttribute(value);
        }

        return attributeExtractor.getShortenedEductString();
    }

}
