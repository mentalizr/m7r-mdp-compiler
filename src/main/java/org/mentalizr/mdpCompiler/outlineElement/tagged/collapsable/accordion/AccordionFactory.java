package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class AccordionFactory extends OutlineElementFactory {

    public AccordionFactory() {
        super(Accordion.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new Accordion();
    }
}
