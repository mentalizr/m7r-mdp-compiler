package org.mentalizr.mdpCompiler.outlineElement.tagged.html;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.HtmlIdValidator;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

import java.util.HashSet;
import java.util.Set;

public class HtmlAttributesParser extends OutlineElementTaggedAttributesParser {

    public HtmlAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public OutlineElementTaggedAttributes getOutlineElementTaggedAttributes() {
        return new HtmlAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(HtmlAttributes.NAME_ID)
                .withNoEmptyValue()
                .withValidator(new HtmlIdValidator())
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(HtmlAttributes.NAME_MARGIN_TOP)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("0")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(HtmlAttributes.NAME_MARGIN_BOTTOM)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("0")
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);

    }

}
