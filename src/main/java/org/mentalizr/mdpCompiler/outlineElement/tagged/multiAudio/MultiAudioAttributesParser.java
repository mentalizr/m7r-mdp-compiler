package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.*;
import org.mentalizr.mdpCompiler.attributeProfile.validator.HtmlIdValidator;
import org.mentalizr.mdpCompiler.attributeProfile.validator.IntegerRange;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;
import org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion.MCQuestionAttributes;

import java.util.HashSet;
import java.util.Set;

public class MultiAudioAttributesParser extends OutlineElementTaggedAttributesParser {

    public MultiAudioAttributesParser(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public MultiAudioAttributes getOutlineElementTaggedAttributes() {
        return new MultiAudioAttributes(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = new HashSet<>();

        attributeSpecSet.add(new AttributeSpecBuilder(MCQuestionAttributes.ID)
                .withNoEmptyValue()
                .withValidator(new HtmlIdValidator())
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(MultiAudioAttributes.NAME_MARGIN_TOP)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("0")
                .build());
        attributeSpecSet.add(new AttributeSpecBuilder(MultiAudioAttributes.NAME_MARGIN_BOTTOM)
                .withValidator(new IntegerRange(0, 5))
                .withDefaultValue("0")
                .build());

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);

        return new AttributeProfile(attributeSpecs);
    }
}
