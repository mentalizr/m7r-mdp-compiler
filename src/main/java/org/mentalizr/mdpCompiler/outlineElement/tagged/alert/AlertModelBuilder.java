package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

public class AlertModelBuilder extends OutlineElementTaggedModelBuilder {

    public AlertModelBuilder() {
        super(new Alert());
    }

    @Override
    public AlertModel getModel(Extraction extraction) throws MDPSyntaxError {

        makeAssertions(extraction);

        AlertModel alertModel = new AlertModel();

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        alertModel.setMdpTag(mdpTag);

        alertModel.setText(extraction.getLines().get(1).asString().trim());

        return alertModel;
    }

    private void makeAssertions(Extraction extraction) throws MDPSyntaxError {
        if (!(extraction instanceof AlertExtraction))
            throw new RuntimeException(AlertExtraction.class.getSimpleName() + " expected.");

        if (extraction.isEmpty())
            throw new IllegalStateException("Insufficient number of lines.");

        if (extraction.getNrOfLines() != 2)
            throw new MDPSyntaxError(extraction.getTagLine(), "Exactly one text line for @alert expected.");
    }

}
