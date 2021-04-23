package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class CollapseFactory extends OutlineElementFactory {

    public CollapseFactory() {
        super(Collapse.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new Collapse();
    }
}
