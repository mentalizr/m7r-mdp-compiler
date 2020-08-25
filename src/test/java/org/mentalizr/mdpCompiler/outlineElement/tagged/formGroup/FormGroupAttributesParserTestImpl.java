package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.attributeParser.AttributeParserException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfile;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeProfileException;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeSpec;
import org.mentalizr.mdpCompiler.attributeProfile.AttributeSpecs;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

import java.util.Set;

public class FormGroupAttributesParserTestImpl extends FormGroupAttributesParser {


    public FormGroupAttributesParserTestImpl(String attributeString) throws AttributeParserException, AttributeProfileException {
        super(attributeString);
    }

    @Override
    public OutlineElementTaggedAttributes getOutlineElementTaggedAttributes() {
        return new FormGroupAttributesTestImpl(this.attributes);
    }

    @Override
    protected AttributeProfile getAttributeProfile() {

        Set<AttributeSpec> attributeSpecSet = this.getCommonAttributeSpecSet();

        AttributeSpecs attributeSpecs = new AttributeSpecs(attributeSpecSet);
        return new AttributeProfile(attributeSpecs);
    }

}
