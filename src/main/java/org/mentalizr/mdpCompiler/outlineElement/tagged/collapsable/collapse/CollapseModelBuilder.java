package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableModelBuilder;

public class CollapseModelBuilder extends CollapsableModelBuilder {

    public CollapseModelBuilder() {
        super(new Collapse());
    }

    @Override
    public CollapseModel getModel(Extraction extraction) throws MDPSyntaxError {
        return (CollapseModel) super.getModel(extraction);
    }
}
