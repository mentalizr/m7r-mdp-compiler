package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableCardContent;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableModel;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.List;
import java.util.UUID;

public class CollapseRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        CollapsableModel collapsableModel = (CollapsableModel) outlineElementModel;
        CollapsableAttributes collapsableAttributes = collapsableModel.getCollapsableAttributes();

        String id = obtainId(collapsableAttributes);
        String marginTop = collapsableAttributes.getMarginTop();
        String marginBottom = collapsableAttributes.getMarginBottom();

        int indent = compilerContext.getIndentLevel();

        result.addLn(indent, "<div class=\"mt-" + marginTop + " mb-" + marginBottom + "\" id=\"" + id + "\">");

        this.renderButtons(collapsableModel, indent, id, result);

        this.renderCollapseList(collapsableModel, indent, id, result);

        result.addLn(indent, "</div>");

    }

    private String obtainId(CollapsableAttributes collapsableAttributes) {
        if (collapsableAttributes.hasId()) return collapsableAttributes.getId();
        return "genId-" + UUID.randomUUID();
    }

    private void renderButtons(CollapsableModel collapsableModel, int indent, String id, Result result) {

        result.addLn(indent + 1, "<p>");

        List<CollapsableCardContent> collapsableCardContentList = collapsableModel.getCollapsableCardContentList();
        for (CollapsableCardContent collapsableCardContent : collapsableCardContentList) {
            String targetId = id + "_collapse_" + collapsableCardContent.getIndex();
            result.addLn(indent + 2, "<button class=\"btn btn-primary\" type=\"button\" data-toggle=\"collapse\" data-target=\"#" + targetId + "\" aria-expanded=\"false\" aria-controls=\"" + targetId + "\">");
            result.addLn(indent + 3, collapsableCardContent.getHeader());
            result.addLn(indent + 2, "</button>");
        }

        result.addLn(indent + 1, "</p>");
    }

    private void renderCollapseList(CollapsableModel collapsableModel, int indent, String id, Result result) throws MDPSyntaxError {

        CollapsableAttributes collapsableAttributes = collapsableModel.getCollapsableAttributes();
        for (CollapsableCardContent collapsableCardContent : collapsableModel.getCollapsableCardContentList()) {
            renderCollapse(collapsableAttributes, indent, id, collapsableCardContent, result);
        }

    }

    private void renderCollapse(CollapsableAttributes collapsableAttributes, int indent, String id, CollapsableCardContent collapsableCardContent, Result result) throws MDPSyntaxError {
        int collapsableIndex = collapsableCardContent.getIndex();
        String elementId = id + "_collapse_" + collapsableIndex;

        result.addLn(indent + 1, "<div class=\"collapse" + this.getShowFirst(collapsableAttributes, collapsableIndex) + "\" id=\"" + elementId + "\" data-parent=\"#" + id + "\">");
        result.addLn(indent + 2, "<div class=\"card card-body\">");

        this.processCardContent(collapsableCardContent, indent, result);

        result.addLn(indent + 2, "</div>");
        result.addLn(indent + 1, "</div>");
    }

    private void processCardContent(CollapsableCardContent collapsableCardContent, int indent, Result result) throws MDPSyntaxError {

        if (collapsableCardContent.getNrOfContentLines() <= 1) {
            if (collapsableCardContent.getNrOfContentLines() == 1) {
                String cardContentSingleLine = collapsableCardContent.getContent().get(0).asString();
                String cardContentPreprocessed = this.inlineParserMDP.parse(cardContentSingleLine);
                result.addLn(indent + 3, cardContentPreprocessed);
            }
            return;
        }

        Document cardContentDocument = collapsableCardContent.getContentAsDocument();
        MDPCompiler.compileSubdocument(cardContentDocument, result, new CompilerContext(false, indent + 2));
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
