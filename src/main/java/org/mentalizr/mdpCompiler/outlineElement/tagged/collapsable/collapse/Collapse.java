package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.*;

public class Collapse extends OutlineElementTagged {

    public static final String TAG = "@collapse";

    public Collapse(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new CollapsableExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        CollapsableAttributes collapsableAttributes = (CollapsableAttributes) this.outlineElementTaggedAttributes;
        return new CollapsableModelBuilder(collapsableAttributes);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        CollapsableAttributes collapsableAttributes = (CollapsableAttributes) this.outlineElementTaggedAttributes;
        CollapsableModel collapsableModel = (CollapsableModel) this.outlineElementModel;
        return new CollapseRenderer(collapsableAttributes, collapsableModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new CollapsableAttributesFactory();
    }

}
