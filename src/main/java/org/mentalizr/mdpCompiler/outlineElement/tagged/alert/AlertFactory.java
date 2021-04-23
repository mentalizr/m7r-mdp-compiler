package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class AlertFactory extends OutlineElementFactory {

    public AlertFactory() {
        super(Alert.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new Alert();
    }
}
