package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.PredefinedStrings;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupAttributesParser;

import java.util.Set;

import static org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupAttributes.*;

public class InputGroupAttributesParser extends FormGroupAttributesParser {

    public InputGroupAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public InputGroupAttributes getOutlineElementTaggedAttributes() {
        return new InputGroupAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = this.getCommonAttributeSpecSet();

        attributeSpecSet.add(new AttributeSpecBuilder(ATTRIBUTE_NAME_INPUTTYPE)
                .withDefaultValue(VALUE_TEXT)
                .withValidator(new PredefinedStrings(VALUE_DATE, VALUE_TIME, VALUE_TEXT))
                .build()
        );

        attributeSpecSet.add(new AttributeSpecBuilder(ATTRIBUTE_NAME_PLACEHOLDER)
                .withDefaultValue("")
                .build()
        );

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);
        return new AttributeProfile(attributeSpecs);
    }

}
