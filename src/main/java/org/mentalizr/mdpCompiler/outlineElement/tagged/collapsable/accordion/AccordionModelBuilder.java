package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableModelBuilder;

public class AccordionModelBuilder extends CollapsableModelBuilder {

    public AccordionModelBuilder() {
        super(new Accordion());
    }

    @Override
    public AccordionModel getModel(Extraction extraction) throws MDPSyntaxError {
        return (AccordionModel) super.getModel(extraction);
    }
}
