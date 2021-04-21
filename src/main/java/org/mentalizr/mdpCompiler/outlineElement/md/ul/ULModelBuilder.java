package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertExtraction;

import java.util.List;

public class ULModelBuilder implements OutlineElementModelBuilder {

//    private final List<Line> lines;
//    private ULModel ulModel;

    public ULModelBuilder() {
//        this.lines = Lines.shallowCopy(lines);
//        this.ulModel = null;
    }

    @Override
    public ULModel getModel(Extraction extraction) {

        if (!(extraction instanceof ULExtraction))
            throw new RuntimeException(ULExtraction.class.getSimpleName() + " expected.");

        List<Line> lines = extraction.getLines();

        ULModel ulModel = new ULModel();
        for (Line line : lines) {
            if (line.asString().startsWith("* ")) {
                ulModel.addItem(line.asString().substring(2).trim());
            }
        }

        return ulModel;
    }

}
