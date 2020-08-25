package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

public class HeadingModel implements OutlineElementModel {

    private String heading;

    public HeadingModel() {
        this.heading = "";
    }

    public void addHeading(String heading) {
        this.heading = heading;
    }

    public String getHeading() {
        return this.heading;
    }
}
