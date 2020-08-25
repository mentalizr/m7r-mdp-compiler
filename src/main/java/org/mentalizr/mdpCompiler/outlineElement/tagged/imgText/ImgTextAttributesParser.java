package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.BooleanType;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.attributeProfile.validator.PositiveDecimal;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

import java.util.HashSet;
import java.util.Set;

public class ImgTextAttributesParser extends OutlineElementTaggedAttributesParser {

    public ImgTextAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public ImgTextAttributes getOutlineElementTaggedAttributes() {
        return new ImgTextAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(ImgTextAttributes.NAME_ALT)
                .withDefaultValue("")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(ImgTextAttributes.NAME_IMG_COL_WIDTH)
                .withDefaultValue("5")
                .withValidator(new IntegerRange(1, 11))
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(ImgTextAttributes.NAME_IMG_EXPAND)
                .withValidator(new BooleanType())
                .withDefaultValue("true")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(ImgTextAttributes.NAME_MARGIN_TOP)
                .withValidator(new PositiveDecimal())
                .withDefaultValue("1")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(ImgTextAttributes.NAME_MARGIN_BOTTOM)
                .withValidator(new PositiveDecimal())
                .withDefaultValue("1")
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);
    }
}
