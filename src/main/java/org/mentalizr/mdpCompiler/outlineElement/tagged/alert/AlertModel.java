package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

public class AlertModel extends OutlineElementTaggedModel {

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

    public AlertAttributes getAlertAttributes() {
        return (AlertAttributes) this.mdpTag.getAttributes();
    }

}
