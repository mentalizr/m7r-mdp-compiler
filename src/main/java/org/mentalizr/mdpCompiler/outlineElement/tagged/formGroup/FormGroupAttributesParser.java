package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeSpec;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeSpecBuilder;
import org.mentalizr.mdpCompiler.attributeProfile.validator.BooleanType;
import org.mentalizr.mdpCompiler.attributeProfile.validator.HtmlIdValidator;
import org.mentalizr.mdpCompiler.attributeProfile.validator.PredefinedStrings;
import org.mentalizr.mdpCompiler.attributeProfile.validator.StringWithExclusions;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

import java.util.HashSet;
import java.util.Set;

public abstract class FormGroupAttributesParser extends OutlineElementTaggedAttributesParser {

    public FormGroupAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    protected Set<AttributeSpec> getCommonAttributeSpecSet() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(FormGroupAttributes.ATTRIBUTE_NAME_ID)
                .isRequired()
                .withNoEmptyValue()
                .withValidator(new StringWithExclusions("."))
                .build()
        );

        attributeSpecSet.add(new AttributeSpecBuilder(FormGroupAttributes.ATTRIBUTE_NAME_REF_ID)
                .withNoEmptyValue()
                .withValidator(new StringWithExclusions("."))
                .build()
        );

        attributeSpecSet.add(new AttributeSpecBuilder(FormGroupAttributes.ATTRIBUTE_NAME_SCOPE)
                .withNoEmptyValue()
                .withValidator(new PredefinedStrings(FormGroupAttributes.VALUE_PAGE, FormGroupAttributes.VALUE_PROGRAM))
                .withDefaultValue(FormGroupAttributes.VALUE_PAGE)
                .build()
        );

        attributeSpecSet.add(new AttributeSpecBuilder(FormGroupAttributes.ATTRIBUTE_NAME_SCOPE_ID)
                .withNoEmptyValue()
                .withValidator(new HtmlIdValidator())
                .withDefaultValue(FormGroupAttributes.VALUE_GENERIC)
                .build()
        );

        attributeSpecSet.add(new AttributeSpecBuilder(FormGroupAttributes.ATTRIBUTE_NAME_READONLY)
                .withNoEmptyValue()
                .withValidator(new BooleanType())
                .withDefaultValue("false")
                .build()
        );

        return attributeSpecSet;
    }

}