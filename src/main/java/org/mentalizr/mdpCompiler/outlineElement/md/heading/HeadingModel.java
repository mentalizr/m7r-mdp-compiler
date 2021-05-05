package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

public class HeadingModel extends OutlineElementModel {

    private String heading;

    public HeadingModel(Heading heading) {
        super(heading);
        this.heading = "";
    }

    public void addHeading(String heading) {
        this.heading = heading;
    }

    public String getHeading() {
        return this.heading;
    }

    public int getHeadingLevel() {
        Heading heading = (Heading) this.outlineElement;
        return heading.getHeadingLevel();
    }
}
