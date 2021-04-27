package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableCardContent;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.UUID;

public class AccordionRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        AccordionModel accordionModel = (AccordionModel) outlineElementModel;
        CollapsableAttributes collapsableAttributes = accordionModel.getCollapsableAttributes();

        String id = obtainId(collapsableAttributes);
        String marginTop = collapsableAttributes.getMarginTop();
        String marginBottom = collapsableAttributes.getMarginBottom();

        int indent = compilerContext.getIndentLevel();

        result.addLn(indent, "<div class=\"accordion mt-" + marginTop + " mb-" + marginBottom + "\" id=\"" + id + "\">");

        for (int i = 0; i < accordionModel.getCollapsableCardContentList().size(); i++) {

            result.addLn(indent + 1, "<div class=\"card\">");

            createAccordionCardHeader(accordionModel, id, i, indent, result);
            createCardBody(accordionModel, collapsableAttributes, id, i, indent, result);

            result.addLn(indent + 1,"</div>");
        }

        result.addLn(indent, "</div>");
    }

    private String obtainId(CollapsableAttributes collapsableAttributes) {
        if (collapsableAttributes.hasId()) return collapsableAttributes.getId();
        return "genId-" + UUID.randomUUID();
    }

    private void createAccordionCardHeader(AccordionModel accordionModel, String id, int cardIndex, int indent, Result result) {
        String cardHeaderId = getCardHeaderId(id, cardIndex);
        String cardCollapseId = getCardCollapseId(id, cardIndex);
        CollapsableCardContent collapsableCardContent = accordionModel.getCollapsableCardContentList().get(cardIndex);
        String cardContentHeaderPreprocessed = this.inlineParserMDP.parse(collapsableCardContent.getHeader());

        result.addLn(indent + 2, "<div class=\"card-header\" id=\"" + cardHeaderId + "\">");
        result.addLn(indent + 3, "<h5 class=\"mb-0\">");
        result.addLn(indent + 4, "<button class=\"btn btn-link\" type=\"button\" data-toggle=\"collapse\" data-target=\"#" + cardCollapseId + "\" aria-expanded=\"true\" aria-controls=\"" + cardCollapseId + "\">");
        result.addLn(indent + 5, "" + cardContentHeaderPreprocessed);
        result.addLn(indent + 4, "</button>");
        result.addLn(indent + 3, "</h5>");
        result.addLn(indent + 2, "</div>");
    }

    private void createCardBody(AccordionModel collapsableModel, CollapsableAttributes collapsableAttributes, String id, int cardIndex, int indent, Result result) throws MDPSyntaxError {
        String cardHeaderId = getCardHeaderId(id, cardIndex);
        String cardCollapseId = getCardCollapseId(id, cardIndex);
        CollapsableCardContent collapsableCardContent = collapsableModel.getCollapsableCardContentList().get(cardIndex);

        // TODO invoke InlineParser

        result.addLn(indent + 2, "<div id=\"" + cardCollapseId + "\" class=\"collapse" + getShowFirst(collapsableAttributes, cardIndex) + "\" aria-labelledby=\"" + cardHeaderId + "\" data-parent=\"#" + id + "\">");
        result.addLn(indent + 3, "<div class=\"card-body\">");

        processCardContent(collapsableCardContent, indent, result);

        result.addLn(indent + 3, "</div>");
        result.addLn(indent + 2, "</div>");
    }

    private void processCardContent(CollapsableCardContent collapsableCardContent, int indent, Result result) throws MDPSyntaxError {
        if (collapsableCardContent.hasSingleLine()) {
            String cardContentSingleLine = collapsableCardContent.getSingleLine();
            String cardContentPreprocessed = this.inlineParserMDP.parse(cardContentSingleLine);
            result.addLn(indent + 5, cardContentPreprocessed);
        } else {
            MDPCompiler.renderSubdocument(collapsableCardContent.getChildElements(), result, new CompilerContext(false, indent + 3));
        }

//        if (collapsableCardContent.getNrOfContentLines() <= 1) {
//            if (collapsableCardContent.getNrOfContentLines() == 1) {
//                String cardContentSingleLine = collapsableCardContent.getContent().get(0).asString();
//                String cardContentPreprocessed = this.inlineParserMDP.parse(cardContentSingleLine);
//                result.addLn(indent + 5, cardContentPreprocessed);
//            }
//            return;
//        }
//
//        Document cardContentDocument = collapsableCardContent.getContentAsDocument();
//        MDPCompiler.compileSubdocument(cardContentDocument, result, new CompilerContext(false, indent + 3));
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
