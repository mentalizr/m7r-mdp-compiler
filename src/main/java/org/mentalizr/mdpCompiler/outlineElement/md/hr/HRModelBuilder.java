package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class HRModelBuilder implements OutlineElementModelBuilder {

    public HRModelBuilder(List<Line> lines) {
    }

    @Override
    public HRModel getModel() throws MDPSyntaxError {
        return new HRModel();
    }

}
