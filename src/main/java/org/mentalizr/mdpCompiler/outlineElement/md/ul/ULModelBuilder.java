package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class ULModelBuilder implements OutlineElementModelBuilder {

    private final List<Line> lines;
    private ULModel ulModel;

    public ULModelBuilder(List<Line> lines) {
        this.lines = Lines.shallowCopy(lines);
        this.ulModel = null;
    }

    @Override
    public ULModel getModel() {
        if (this.ulModel == null) {
            buildModel();
        }
        return this.ulModel;
    }

    private void buildModel() {
        this.ulModel = new ULModel();
        for (Line line : this.lines) {
            if (line.asString().startsWith("* ")) {
                this.ulModel.addItem(line.asString().substring(2).trim());
            }
        }
    }

}
