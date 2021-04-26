package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

public class HeadingModelBuilder extends OutlineElementModelBuilder {

//    private final List<Line> lines;
    private final int headerLevel;
//    private HeadingModel headingModel;

    public HeadingModelBuilder(int headerLevel) {
        // TODO works???
        super(new H1());
//        this.lines = lines;
        this.headerLevel = headerLevel;
//        this.headingModel = null;
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
