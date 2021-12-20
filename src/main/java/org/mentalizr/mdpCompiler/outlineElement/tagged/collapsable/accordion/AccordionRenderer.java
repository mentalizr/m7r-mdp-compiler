package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableCardContent;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.util.UUID;

public class AccordionRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        AccordionModel accordionModel = (AccordionModel) outlineElementModel;
        CollapsableAttributes collapsableAttributes = accordionModel.getCollapsableAttributes();

        String id = obtainId(collapsableAttributes);
        String marginTop = collapsableAttributes.getMarginTop();
        String marginBottom = collapsableAttributes.getMarginBottom();

        int indent = compilerContext.getIndentLevel();

        htmlBuilder.addLn(indent, "<div class=\"accordion mt-" + marginTop + " mb-" + marginBottom + "\" id=\"" + id + "\">");

        for (int i = 0; i < accordionModel.getCollapsableCardContentList().size(); i++) {

            htmlBuilder.addLn(indent + 1, "<div class=\"card\">");

            createAccordionCardHeader(accordionModel, id, i, indent, htmlBuilder);
            createCardBody(accordionModel, collapsableAttributes, id, i, indent, htmlBuilder);

            htmlBuilder.addLn(indent + 1,"</div>");
        }

        htmlBuilder.addLn(indent, "</div>");
    }

    private String obtainId(CollapsableAttributes collapsableAttributes) {
        if (collapsableAttributes.hasId()) return collapsableAttributes.getId();
        return "genId-" + UUID.randomUUID();
    }

    private void createAccordionCardHeader(AccordionModel accordionModel, String id, int cardIndex, int indent, HtmlBuilder htmlBuilder) {
        String cardHeaderId = getCardHeaderId(id, cardIndex);
        String cardCollapseId = getCardCollapseId(id, cardIndex);
        CollapsableCardContent collapsableCardContent = accordionModel.getCollapsableCardContentList().get(cardIndex);
        String cardContentHeaderPreprocessed = this.inlineParserMDP.parse(collapsableCardContent.getHeader());

        htmlBuilder.addLn(indent + 2, "<div class=\"card-header\" id=\"" + cardHeaderId + "\">");
        htmlBuilder.addLn(indent + 3, "<h5 class=\"mb-0\">");
        htmlBuilder.addLn(indent + 4, "<button class=\"btn btn-link\" type=\"button\" data-toggle=\"collapse\" data-target=\"#" + cardCollapseId + "\" aria-expanded=\"true\" aria-controls=\"" + cardCollapseId + "\">");
        htmlBuilder.addLn(indent + 5, "" + cardContentHeaderPreprocessed);
        htmlBuilder.addLn(indent + 4, "</button>");
        htmlBuilder.addLn(indent + 3, "</h5>");
        htmlBuilder.addLn(indent + 2, "</div>");
    }

    private void createCardBody(AccordionModel collapsableModel, CollapsableAttributes collapsableAttributes, String id, int cardIndex, int indent, HtmlBuilder htmlBuilder) {
        String cardHeaderId = getCardHeaderId(id, cardIndex);
        String cardCollapseId = getCardCollapseId(id, cardIndex);
        CollapsableCardContent collapsableCardContent = collapsableModel.getCollapsableCardContentList().get(cardIndex);

        // TODO invoke InlineParser

        htmlBuilder.addLn(indent + 2, "<div id=\"" + cardCollapseId + "\" class=\"collapse" + getShowFirst(collapsableAttributes, cardIndex) + "\" aria-labelledby=\"" + cardHeaderId + "\" data-parent=\"#" + id + "\">");
        htmlBuilder.addLn(indent + 3, "<div class=\"card-body\">");

        processCardContent(collapsableCardContent, indent, htmlBuilder);

        htmlBuilder.addLn(indent + 3, "</div>");
        htmlBuilder.addLn(indent + 2, "</div>");
    }

    private void processCardContent(CollapsableCardContent collapsableCardContent, int indent, HtmlBuilder htmlBuilder) {
        if (collapsableCardContent.hasSingleLine()) {
            String cardContentSingleLine = collapsableCardContent.getSingleLine();
            String cardContentPreprocessed = this.inlineParserMDP.parse(cardContentSingleLine);
            htmlBuilder.addLn(indent + 5, cardContentPreprocessed);
        } else {
            MDPCompiler.renderSubdocument(collapsableCardContent.getChildElements(), htmlBuilder, new CompilerContext(false, indent + 3));
        }
    }

    private String getCardHeaderId(String id, int cardIndex) {
        return id + "_heading_" + cardIndex;
    }

    private String getCardCollapseId(String id, int cardIndex) {
        return id + "_collapse_" + cardIndex;
    }

    private String getShowFirst(CollapsableAttributes collapsableAttributes, int cardIndex) {
        if (cardIndex == 0 && collapsableAttributes.isShowFirst()) return " show";
        return "";
    }

}
