package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

public class AlertModel implements OutlineElementModel {

    private String text;

    public AlertModel() {
        this.text = "";
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
