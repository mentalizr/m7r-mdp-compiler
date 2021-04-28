package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

public class HeadingModelBuilder extends OutlineElementModelBuilder {

    public HeadingModelBuilder(Heading heading) {
        super(heading);
    }

    @Override
    public HeadingModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof HeadingExtraction))
            throw new RuntimeException(HeadingExtraction.class.getSimpleName() + " expected.");

        if (extraction.getNrOfLines() != 1)
            throw new MDPSyntaxError(extraction.getTagLine(), "Number of heading lines must be 1.");

        String tagLine = extraction.getTagLine().asString();

        Heading heading = (Heading) this.outlineElement;
        HeadingModel headingModel = new HeadingModel(heading);

        int headingLevel = heading.getHeadingLevel();
        String headingString = tagLine.substring(headingLevel).trim();

        headingModel.addHeading(headingString);

        return headingModel;
    }

}
