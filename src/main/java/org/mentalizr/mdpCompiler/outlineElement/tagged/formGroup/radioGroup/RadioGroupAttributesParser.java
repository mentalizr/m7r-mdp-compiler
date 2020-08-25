package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.StringWithExclusions;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupAttributesParser;
import java.util.Set;

public class RadioGroupAttributesParser extends FormGroupAttributesParser {

    public RadioGroupAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public RadioGroupAttributes getOutlineElementTaggedAttributes() {
        return new RadioGroupAttributes(this.attributes, this.openSimpleAttributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = this.getCommonAttributeSpecSet();

        attributeSpecSet.add(new AttributeSpecBuilder(RadioGroupAttributes.ATTRIBUTE_NAME_NAME)
                .isRequired()
                .withNoEmptyValue()
                .withValidator(new StringWithExclusions("."))
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet, true);
        return new AttributeProfile(attributeSpecs);
    }
}
