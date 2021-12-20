package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.util.List;
import java.util.UUID;

public class MCQuestionRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        MCQuestionModel mcQuestionModel = (MCQuestionModel) outlineElementModel;
        MCQuestionAttributes mcQuestionAttributes = mcQuestionModel.getMcQuestionAttributes();

        String id = obtainId(mcQuestionAttributes);
        String marginTop = mcQuestionAttributes.getMarginTop();
        String marginBottom = mcQuestionAttributes.getMarginBottom();

        int indent = compilerContext.getIndentLevel();

        htmlBuilder.addLn(indent, "<div id=\"" + id + "\" class=\"" + getCssMCQuestionTypeClass(mcQuestionModel) + " card mb-" + marginBottom + " mt-" + marginTop + " m7r-mc-state-answering\">");
        htmlBuilder.addLn(indent + 1, "<div class=\"card-body\">");

        this.renderTitle(mcQuestionModel, indent, htmlBuilder);

        this.renderQuestionText(mcQuestionModel, indent, htmlBuilder);

        this.renderAnsweringOptions(mcQuestionModel, indent, id, htmlBuilder);

        this.renderFeedbackButtonFooter(indent, htmlBuilder);

        htmlBuilder.addLn(indent + 1, "</div>");

        htmlBuilder.addLn(indent, "</div>");

    }

    private String obtainId(MCQuestionAttributes mcQuestionAttributes) {
        if (mcQuestionAttributes.hasId()) return mcQuestionAttributes.getId();
        return "genId-" + UUID.randomUUID();
    }

    private String getCssMCQuestionTypeClass(MCQuestionModel mcQuestionModel) {
        return mcQuestionModel.getMcQuestionType().equals(MCQuestionModel.MCQuestionType.ONE) ? "m7r-mc-one" : "m7r-mc-multi";
    }

    private void renderTitle(MCQuestionModel mcQuestionModel, int indent, HtmlBuilder htmlBuilder) {
        if (mcQuestionModel.hasTitle()) {
            htmlBuilder.addLn(indent + 2, "<h5 class=\"card-title\">" + mcQuestionModel.getTitle() + "</h5>");
        }
    }

    private void renderQuestionText(MCQuestionModel mcQuestionModel, int indent, HtmlBuilder htmlBuilder) {
        htmlBuilder.addLn(indent + 2, "<p class=\"card-text\"><strong>" + mcQuestionModel.getQuestion() + "</strong></p>");
    }

    private void renderAnsweringOptions(MCQuestionModel mcQuestionModel, int indent, String id, HtmlBuilder htmlBuilder) {
        List<MCQuestionAnsweringOption> mcQuestionAnsweringOptionList = mcQuestionModel.getMcQuestionAnsweringOptions();
        for (int index = 0; index < mcQuestionAnsweringOptionList.size(); index++) {
            MCQuestionAnsweringOption mcQuestionAnsweringOption = mcQuestionAnsweringOptionList.get(index);
            this.renderAnsweringOption(indent, id, index, mcQuestionAnsweringOption, htmlBuilder);
        }
    }

    private void renderAnsweringOption(int indent, String id, int index, MCQuestionAnsweringOption mcQuestionAnsweringOption, HtmlBuilder htmlBuilder) {

        String optionId = id + "_" + (index + 1);
        String cssCorrectClass = mcQuestionAnsweringOption.isCorrect() ? " m7r-mc-option-correct" : "";

        htmlBuilder.addLn(indent + 2, "<div id=\"" + optionId + "\" class=\"m7r-mc-option p-2 rounded mt-2" + cssCorrectClass + "\">");
        htmlBuilder.addLn(indent + 3, "<span class=\"m7r-mc-icon\"></span>");
        htmlBuilder.addLn(indent + 3, "<span class=\"ml-2\">" + mcQuestionAnsweringOption.getText() + "</span>");
        htmlBuilder.addLn(indent + 2, "</div>");
    }

    private void renderFeedbackButtonFooter(int indent, HtmlBuilder htmlBuilder) {

        htmlBuilder.addLn(indent + 2, "<div class=\"mt-4\">");

        renderFeedbackFail(indent, htmlBuilder);
        renderFeedbackSuccess(indent, htmlBuilder);
        renderButton(indent, "m7r-mc-button-check", "m7r-mc-icon-check", "Überprüfen", htmlBuilder);
        renderButton(indent, "m7r-mc-button-show", "m7r-mc-icon-show", "Lösung anzeigen", htmlBuilder);
        renderButton(indent, "m7r-mc-button-retry", "m7r-mc-icon-retry", "Wiederholen", htmlBuilder);

        htmlBuilder.addLn(indent + 2, "</div>");
    }

    private void renderFeedbackFail(int indent, HtmlBuilder htmlBuilder) {
        htmlBuilder.addLn(indent + 3, "<div class=\"m7r-mc-feedback-fail btn border border-danger text-danger font-weight-bold px-3 d-none\">");
        htmlBuilder.addLn(indent + 4, "<span class=\"m7r-mc-icon-fail\"></span>");
        htmlBuilder.addLn(indent + 4, "<span class=\"pl-2\">Leider falsch!</span>");
        htmlBuilder.addLn(indent + 3, "</div>");
    }

    private void renderFeedbackSuccess(int indent, HtmlBuilder htmlBuilder) {
        htmlBuilder.addLn(indent + 3, "<div class=\"m7r-mc-feedback-success btn border border-success text-success font-weight-bold px-3 d-none\">");
        htmlBuilder.addLn(indent + 4, "<span class=\"m7r-mc-icon-success\"></span>");
        htmlBuilder.addLn(indent + 4, "<span class=\"pl-2\">Richtig!</span>");
        htmlBuilder.addLn(indent + 3, "</div>");
    }

    private void renderButton(int indent, String cssButtonClass, String cssIconClass, String text, HtmlBuilder htmlBuilder) {
        htmlBuilder.addLn(indent + 3, "<button type=\"button\" class=\"" + cssButtonClass + " btn btn-primary px-3 d-none\">");
        htmlBuilder.addLn(indent + 4, "<span class=\"" + cssIconClass + " m7r-mc-icon-check\"></span>");
        htmlBuilder.addLn(indent + 4, "<span class=\"pl-2\">" + text + "</span>");
        htmlBuilder.addLn(indent + 3, "</button>");
    }
}
