package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesParser;

public class MultiAudioAttributesFactory implements OutlineElementTaggedAttributesFactory {

    @Override
    public OutlineElementTaggedAttributesParser createMDPTagAttributes(String attributesString) throws AttributeParserException, AttributeProfileException {
        return new MultiAudioAttributesParser(attributesString);
    }
}
