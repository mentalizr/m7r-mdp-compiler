package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

public class HeadingModelBuilder extends OutlineElementModelBuilder {

    private final int headerLevel;

    public HeadingModelBuilder(int headerLevel) {
        super(new H1());
        this.headerLevel = headerLevel;
    }

    @Override
    public HeadingModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof HeadingExtraction))
            throw new RuntimeException(HeadingExtraction.class.getSimpleName() + " expected.");

        if (extraction.getNrOfLines() != 1)
            throw new MDPSyntaxError(extraction.getTagLine(), "Number of heading lines must be 1.");

        String tagLine = extraction.getTagLine().asString();

        HeadingModel headingModel = new HeadingModel(this.outlineElement);
        String heading = tagLine.substring(this.headerLevel).trim();
        headingModel.addHeading(heading);

        return headingModel;
    }

}
