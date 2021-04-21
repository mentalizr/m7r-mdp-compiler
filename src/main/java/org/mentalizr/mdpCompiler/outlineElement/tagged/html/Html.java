package org.mentalizr.mdpCompiler.outlineElement.tagged.html;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;

public class Html extends OutlineElementTagged {

    public static final String TAG = "@html";

    public Html(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new HtmlExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new TextBlockModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        HtmlAttributes htmlAttributes = (HtmlAttributes) this.outlineElementTaggedAttributes;
        TextBlockModel textBlockModel = (TextBlockModel) this.outlineElementModel;
        return new HtmlRenderer(htmlAttributes, textBlockModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new HtmlAttributesFactory();
    }
}
