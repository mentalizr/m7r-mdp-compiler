package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class Alert extends OutlineElementTagged {

    public static final String TAG = "@alert";

    public Alert(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new AlertExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        AlertAttributes alertAttributes = (AlertAttributes) this.outlineElementTaggedAttributes;
        return new AlertModelBuilder(alertAttributes);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        AlertAttributes alertAttributes = (AlertAttributes) this.outlineElementTaggedAttributes;
        AlertModel alertModel = (AlertModel) this.outlineElementModel;
        return new AlertRenderer(alertAttributes, alertModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new AlertAttributesFactory();
    }
}
