package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.attributeProfile.validator.PredefinedStrings;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

import java.util.HashSet;
import java.util.Set;

public class AlertAttributesParser extends OutlineElementTaggedAttributesParser {

    public AlertAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public OutlineElementTaggedAttributes getOutlineElementTaggedAttributes() {
        return new AlertAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(AlertAttributes.ATTRIBUTE_NAME_TYPE)
                .isRequired()
                .withNoEmptyValue()
                .withValidator(new PredefinedStrings(AlertAttributes.VALUE_INFO, AlertAttributes.VALUE_EXERCISE))
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(AlertAttributes.ATTRIBUTE_NAME_HEADERSIZE)
                .withNoEmptyValue()
                .withValidator(new IntegerRange(1, 6))
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);

    }

}
