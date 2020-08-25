package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class ParagraphModelBuilder implements OutlineElementModelBuilder {

    private final List<Line> lines;
    private ParagraphModel paragraphModel;

    public ParagraphModelBuilder(List<Line> lines) {
        this.lines = lines;
        this.paragraphModel = null;
    }

    @Override
    public ParagraphModel getModel() {
        if (this.paragraphModel == null) {
            buildModel();
        }
        return this.paragraphModel;
    }

    private void buildModel() {

        this.paragraphModel = new ParagraphModel();

        for (Line line : this.lines) {
            if (!line.asString().isBlank())
                this.paragraphModel.addLine(line.asString());
        }

    }
}
