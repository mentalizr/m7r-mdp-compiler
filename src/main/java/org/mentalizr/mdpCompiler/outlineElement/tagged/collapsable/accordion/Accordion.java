package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.*;
import org.mentalizr.mdpCompiler.result.Result;

public class Accordion extends OutlineElementTagged {

    public static final String TAG = "@accordion";

    public Accordion(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        super(TAG, result, documentIterator);
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new CollapsableLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        CollapsableAttributes collapsableAttributes = (CollapsableAttributes) this.outlineElementTaggedAttributes;
        return new CollapsableModelBuilder(collapsableAttributes, this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        CollapsableAttributes collapsableAttributes = (CollapsableAttributes) this.outlineElementTaggedAttributes;
        CollapsableModel collapsableModel = (CollapsableModel) this.outlineElementModel;
        return new AccordionRenderer(this.result, collapsableAttributes, collapsableModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new CollapsableAttributesFactory();
    }

}
