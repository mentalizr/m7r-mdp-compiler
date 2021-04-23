package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

public class HRModelBuilder extends OutlineElementModelBuilder {

    public HRModelBuilder() {
        super(new HR());
    }

    @Override
    public HRModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof HRExtraction))
            throw new RuntimeException(HRExtraction.class.getSimpleName() + " expected.");

        return new HRModel();
    }

}
