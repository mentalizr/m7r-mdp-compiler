package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.HtmlIdValidator;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributes;

import java.util.HashSet;
import java.util.Set;

public class GridAttributesParser extends OutlineElementTaggedAttributesParser {

    public GridAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public GridAttributes getOutlineElementTaggedAttributes() {
        return new GridAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(CollapsableAttributes.ID)
                .withNoEmptyValue()
                .withValidator(new HtmlIdValidator())
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CollapsableAttributes.MARGIN_TOP)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("0")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CollapsableAttributes.MARGIN_BOTTOM)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("0")
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);

    }


}
