package org.mentalizr.mdpCompiler.attributeProfile;

import org.mentalizr.mdpCompiler.attributeProfile.attributesBuilder.AttributesBuilder;
import org.mentalizr.mdpCompiler.attributeProfile.validator.AttributeValidationException;
import org.mentalizr.mdpCompiler.attributeProfile.validator.AttributeValidator;

import java.util.Set;

public class AttributeProfile {

    private final AttributeSpecs attributeSpecs;

    public AttributeProfile(AttributeSpecs attributeSpecs) {
        this.attributeSpecs = attributeSpecs;
    }

    /**
     * Validates given attributes against attribute specifications. Returns a new object
     * of type Attributes.
     *
     * @param attributes
     * @return
     * @throws AttributeProfileException
     */
    public Attributes validate(Attributes attributes) throws AttributeProfileException {

        checkForIllegalAttributes(attributes);
        checkForPresenceOfRequiredAttributes(attributes);

        AttributesBuilder attributesBuilder = new AttributesBuilder();

        applyAttributeChecks(attributes, attributesBuilder);
        expandDefaults(attributes, attributesBuilder);

        return attributesBuilder.build();
    }

    /**
     * Extracts those attributes that are simple and not specified (simpleOpen). Specified
     * attributes should be validated to avoid unexpected behaviour.
     *
     * @param validatedAttributes
     * @return
     */
    public Attributes extractOpenSimple(Attributes validatedAttributes) throws AttributeProfileException {

        AttributesBuilder attributesBuilder = new AttributesBuilder();

        if (!isSpecifiedForOpenSimpleAttributes()) return attributesBuilder.build();

        for (Attribute attribute : validatedAttributes) {
            if (attribute.isSimpleAttribute() && !this.attributeSpecs.hasAttributeSpec(attribute.getName()))
                attributesBuilder.addSimpleAttribute(attribute.getName());
        }

        return attributesBuilder.build();
    }

    public boolean isSpecifiedForOpenSimpleAttributes() {
        return this.attributeSpecs.isAllowOpenSimpleAttributes();
    }

    private void checkForIllegalAttributes(Attributes attributes) throws IllegalAttributeException {

        for (Attribute attribute : attributes) {
            if (attribute.isSimpleAttribute() && this.attributeSpecs.isAllowOpenSimpleAttributes()) continue;

            String attributeName = attribute.getName();
            boolean hasSpec = this.attributeSpecs.hasAttributeSpec(attributeName);
            if (!hasSpec) throw new IllegalAttributeException(attributeName);
        }
    }

    private void checkForPresenceOfRequiredAttributes(Attributes attributes) throws AttributeProfileException {

        Set<String> requiredAttributeNames = this.attributeSpecs.getNamesOfRequired();

        for (String requiredAttributeName : requiredAttributeNames) {
            if (!attributes.hasAttribute(requiredAttributeName))
                throw new RequiredAttributeMissingException(requiredAttributeName);
        }

    }

    private void applyAttributeChecks(Attributes attributes, AttributesBuilder attributesBuilder) throws AttributeProfileException {
        Set<String> attributeNames = attributes.getAttributeNameSet();
        for (String attributeName : attributeNames) {
            Attribute attribute = attributes.getAttribute(attributeName);
            check(attribute);
            attributesBuilder.addAttribute(attribute);
        }

    }

    private void check(Attribute attribute) throws AttributeValidationException {

        checkSimplicity(attribute);

        if (attribute.isSimpleAttribute()) return;

        checkNoEmptyValue(attribute);
        applyTypeValidator(attribute);

    }

    private void checkSimplicity(Attribute attribute) throws AttributeValidationException {

        boolean hasSpec = this.attributeSpecs.hasAttributeSpec(attribute.getName());

        if (!hasSpec) {
            if (attribute.isSimpleAttribute() && this.attributeSpecs.isAllowOpenSimpleAttributes()) {
                return;
            } else {
                throw new IllegalStateException("Required AttributeSpec not found for attribute: '" + attribute.getName() + "'.");
            }
        }

        AttributeSpec attributeSpec = this.attributeSpecs.getAttributeSpec(attribute.getName());

        if (attributeSpec.isSimple()) {
            if (!attribute.isSimpleAttribute())
                throw new AttributeValidationException(attribute, "Attribute has assignment while specified as simple.");
            return;
        }
    }

    private void checkNoEmptyValue(Attribute attribute) throws AttributeValidationException {

        AttributeSpec attributeSpec = this.attributeSpecs.getAttributeSpec(attribute.getName());

        if (attributeSpec.noEmptyValue() && attribute.getValue().isEmpty())
            throw new AttributeValidationException(attribute, "Attribute value is empty while specified with no empty value.");
    }

    private void applyTypeValidator(Attribute attribute) throws AttributeValidationException {
        AttributeSpec attributeSpec = this.attributeSpecs.getAttributeSpec(attribute.getName());

        if (attributeSpec.hasAttributeValidator()) {
            AttributeValidator attributeValidator = attributeSpec.getAttributeValidator();
            attributeValidator.validate(attribute);
        }
    }

    private void expandDefaults(Attributes attributes, AttributesBuilder attributesBuilder) throws AttributeProfileException {
        Set<String> attributeNames = this.attributeSpecs.getNamesOfNotSetAttributes(attributes);
        for (String attributeName : attributeNames) {
            AttributeSpec attributeSpec = this.attributeSpecs.getAttributeSpec(attributeName);
            expandDefault(attributeSpec, attributesBuilder);
        }
    }

    private void expandDefault(AttributeSpec attributeSpec, AttributesBuilder attributesBuilder) throws AttributeProfileException {
        if (attributeSpec.isRequired())
            throw new RuntimeException("Plausibility error: Can not expand a non existing attribute with default value, that is required. Should be caught earlier.");

        if (attributeSpec.hasDefaultValue()) {
            attributesBuilder.addAttribute(attributeSpec.getAttributeName(), attributeSpec.getDefaultValue());
        }
    }

}
