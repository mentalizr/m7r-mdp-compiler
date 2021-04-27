package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion.Accordion;

public class CollapseModel extends CollapsableModel {

    public CollapseModel(MDPTag mdpTag) {
        super(new Collapse(), mdpTag);
    }

}
