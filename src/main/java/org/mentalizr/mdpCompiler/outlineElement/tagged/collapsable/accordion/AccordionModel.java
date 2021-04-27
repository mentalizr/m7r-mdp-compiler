package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableModel;

public class AccordionModel extends CollapsableModel {

    public AccordionModel(MDPTag mdpTag) {
        super(new Accordion(), mdpTag);
    }

}
