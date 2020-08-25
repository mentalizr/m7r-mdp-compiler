package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.HtmlIdValidator;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.attributeProfile.validator.PredefinedStrings;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributes;

import java.util.HashSet;
import java.util.Set;

public class MCQuestionAttributesParser extends OutlineElementTaggedAttributesParser {

    public MCQuestionAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public MCQuestionAttributes getOutlineElementTaggedAttributes() {
        return new MCQuestionAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(MCQuestionAttributes.ID)
                .withNoEmptyValue()
                .withValidator(new HtmlIdValidator())
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(MCQuestionAttributes.TYPE)
                .withNoEmptyValue()
                .withValidator(new PredefinedStrings(MCQuestionAttributes.TYPE_VALUE_ONE, MCQuestionAttributes.TYPE_VALUE_MULTI, MCQuestionAttributes.TYPE_VALUE_AUTO))
                .withDefaultValue(MCQuestionAttributes.TYPE_VALUE_AUTO)
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CollapsableAttributes.MARGIN_TOP)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("3")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CollapsableAttributes.MARGIN_BOTTOM)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("3")
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);

    }

}
