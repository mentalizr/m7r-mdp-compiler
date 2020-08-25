package org.mentalizr.mdpCompiler.attributeProfile.validator;

import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.attributeProfile.Attribute;

import java.util.Arrays;
import java.util.List;

public class PredefinedStrings extends StringType implements AttributeValidator {

    protected List<String> predefinedStrings;

    public PredefinedStrings(String... predefinedStrings) {
        super();
        this.predefinedStrings = Arrays.asList(predefinedStrings);
    }

    @Override
    public void validate(Attribute attribute) throws AttributeValidationException {
        super.validate(attribute);

        if (!Strings.isOneOf(attribute.getValue(), this.predefinedStrings))
            throw new AttributeValidationException(attribute, "Value not in " + Strings.listing(this.predefinedStrings, ", ", "[", "]") + ".");
    }

}
