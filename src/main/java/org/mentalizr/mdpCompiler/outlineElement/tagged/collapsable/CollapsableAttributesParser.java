package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.HtmlIdValidator;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

import java.util.HashSet;
import java.util.Set;

public class CollapsableAttributesParser extends OutlineElementTaggedAttributesParser {

    public CollapsableAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public CollapsableAttributes getOutlineElementTaggedAttributes() {
        return new CollapsableAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(CollapsableAttributes.ID)
                .withNoEmptyValue()
                .withValidator(new HtmlIdValidator())
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(CollapsableAttributes.SHOW_FIRST)
                .isSimple()
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
