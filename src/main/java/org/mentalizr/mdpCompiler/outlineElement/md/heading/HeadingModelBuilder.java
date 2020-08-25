package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class HeadingModelBuilder implements OutlineElementModelBuilder {

    private final List<Line> lines;
    private final int headerLevel;
    private HeadingModel headingModel;

    public HeadingModelBuilder(List<Line> lines, int headerLevel) {
        this.lines = lines;
        this.headerLevel = headerLevel;
        this.headingModel = null;
    }

    @Override
    public HeadingModel getModel() throws MDPSyntaxError {
        if (this.headingModel == null) {
            buildModel();
        }
        return this.headingModel;
    }

    private void buildModel() {

        if (this.lines.size() != 1) throw new IllegalStateException("Number of heading lines must be 1.");
        String line = this.lines.get(0).asString();

        this.headingModel = new HeadingModel();
        String heading = line.substring(this.headerLevel).trim();
        this.headingModel.addHeading(heading);
    }
}
