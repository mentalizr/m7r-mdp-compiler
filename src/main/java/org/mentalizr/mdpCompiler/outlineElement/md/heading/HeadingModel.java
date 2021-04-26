package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

public class HeadingModel extends OutlineElementModel {

    private String heading;

    public HeadingModel(OutlineElement outlineElement) {
        super(outlineElement);
        this.heading = "";
    }

    public void addHeading(String heading) {
        this.heading = heading;
    }

    public String getHeading() {
        return this.heading;
    }
}
