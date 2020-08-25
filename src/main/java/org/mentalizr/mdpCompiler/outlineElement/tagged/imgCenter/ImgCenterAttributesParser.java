package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

import java.util.HashSet;
import java.util.Set;

public class ImgCenterAttributesParser extends OutlineElementTaggedAttributesParser {

    public ImgCenterAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public ImgCenterAttributes getOutlineElementTaggedAttributes() {
        return new ImgCenterAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(ImgCenterAttributes.NAME_ALT)
                .withDefaultValue("")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(ImgCenterAttributes.NAME_MARGIN_TOP)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("0")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(ImgCenterAttributes.NAME_MARGIN_BOTTOM)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("0")
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);
    }
}
