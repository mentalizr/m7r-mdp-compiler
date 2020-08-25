package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.PositiveInteger;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupAttributesParser;

import java.util.Set;

import static org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup.TextareaGroupAttributes.ATTRIBUTE_NAME_ROWS;

public class TextareaGroupAttributesParser extends FormGroupAttributesParser {


    public TextareaGroupAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public OutlineElementTaggedAttributes getOutlineElementTaggedAttributes() {
        return new TextareaGroupAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = this.getCommonAttributeSpecSet();

        attributeSpecSet.add(new AttributeSpecBuilder(ATTRIBUTE_NAME_ROWS)
                .withDefaultValue("3")
                .withNoEmptyValue()
                .withValidator(new PositiveInteger())
                .build()
        );

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);
        return new AttributeProfile(attributeSpecs);
    }

}
