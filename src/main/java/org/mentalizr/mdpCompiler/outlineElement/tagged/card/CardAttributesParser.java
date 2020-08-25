package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

import java.util.HashSet;
import java.util.Set;

public class CardAttributesParser extends OutlineElementTaggedAttributesParser {

    public CardAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public OutlineElementTaggedAttributes getOutlineElementTaggedAttributes() {
        return new CardAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(CardAttributes.NAME_MARGIN_TOP)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("3")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CardAttributes.NAME_MARGIN_BOTTOM)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("3")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CardAttributes.ATTRIBUTE_NAME_HEADER)
                .withNoEmptyValue()
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CardAttributes.ATTRIBUTE_NAME_BG_COLOR)
                .withNoEmptyValue()
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CardAttributes.ATTRIBUTE_NAME_TEXT_COLOR)
                .withNoEmptyValue()
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);

    }

}
