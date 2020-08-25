package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

import java.util.HashSet;
import java.util.Set;

public class VideoAttributesParser extends OutlineElementTaggedAttributesParser {

    public VideoAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public VideoAttributes getOutlineElementTaggedAttributes() {
        return new VideoAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(VideoAttributes.NAME_POSTER)
                .withNoEmptyValue()
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(VideoAttributes.NAME_MARGIN_TOP)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("3")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(VideoAttributes.NAME_MARGIN_BOTTOM)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("3")
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);
    }
}
