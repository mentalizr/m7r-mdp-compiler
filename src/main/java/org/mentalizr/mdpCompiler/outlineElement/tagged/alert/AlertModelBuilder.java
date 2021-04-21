package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class AlertModelBuilder implements OutlineElementModelBuilder {

    private final AlertAttributes alertAttributes;
//    private final List<Line> lines;

//    private final Line mdpTagLine;
//    private AlertModel alertModel;

    public AlertModelBuilder(AlertAttributes alertAttributes) {

//        if (lines.size() < 1) throw new IllegalStateException(AlertModelBuilder.class.getSimpleName() + ": Insufficient number of lines.");

        this.alertAttributes = alertAttributes;
//        this.lines = Lines.shallowCopy(lines);
//
//        this.mdpTagLine = this.lines.get(0);
//        this.alertModel = null;
    }

    @Override
    public AlertModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof AlertExtraction))
            throw new RuntimeException(AlertExtraction.class.getSimpleName() + " expected.");

        if (extraction.isEmpty())
            throw new IllegalStateException("Insufficient number of lines.");

        if (extraction.getNrOfLines() != 2)
            throw new MDPSyntaxError(extraction.getTagLine(), "Exactly one text line for @alert expected.");

        AlertModel alertModel = new AlertModel();
        alertModel.setText(extraction.getLines().get(1).asString().trim());

        return alertModel;
    }

//    private void buildModel() throws MDPSyntaxError {
//
//        if (this.lines.size() != 2) throw new MDPSyntaxError(this.mdpTagLine, "Exactly one text line for @alert expected.");
//
//        this.alertModel = new AlertModel();
//        this.alertModel.setText(this.lines.get(1).asString().trim());
//    }

}
