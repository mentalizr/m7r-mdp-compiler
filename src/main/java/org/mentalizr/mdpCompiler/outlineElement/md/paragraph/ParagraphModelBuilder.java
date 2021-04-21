package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertExtraction;

import java.util.List;

public class ParagraphModelBuilder implements OutlineElementModelBuilder {

//    private final List<Line> lines;
//    private ParagraphModel paragraphModel;

    public ParagraphModelBuilder() {
//        this.lines = lines;
//        this.paragraphModel = null;
    }

    @Override
    public ParagraphModel getModel(Extraction extraction) {

        if (!(extraction instanceof ParagraphExtraction))
            throw new RuntimeException(ParagraphExtraction.class.getSimpleName() + " expected.");

        List<Line> lines = extraction.getLines();
        ParagraphModel paragraphModel = new ParagraphModel();

        for (Line line : lines) {
            if (!line.asString().isBlank())
                paragraphModel.addLine(line.asString());
        }

        return paragraphModel;
    }
}
