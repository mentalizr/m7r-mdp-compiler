package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.List;
import java.util.UUID;

public class MCQuestionRenderer extends OutlineElementRenderer {

    private final MCQuestionAttributes mcQuestionAttributes;
    private final MCQuestionModel mcQuestionModel;

    public MCQuestionRenderer(Result result, MCQuestionAttributes mcQuestionAttributes, MCQuestionModel mcQuestionModel) {
        super(result);
        this.mcQuestionAttributes = mcQuestionAttributes;
        this.mcQuestionModel = mcQuestionModel;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        String id = obtainId();
        String marginTop = this.mcQuestionAttributes.getMarginTop();
        String marginBottom = this.mcQuestionAttributes.getMarginBottom();

        int indent = compilerContext.getIndentLevel();

        this.result.addLn(indent, "<div id=\"" + id + "\" class=\"" + getCssMCQuestionTypeClass() + " card mb-" + marginBottom + " mt-" + marginTop + " m7r-mc-state-answering\">");
        this.result.addLn(indent + 1, "<div class=\"card-body\">");

        this.renderTitle(indent);

        this.renderQuestionText(indent);

        this.renderAnsweringOptions(indent, id);

        this.renderFeedbackButtonFooter(indent);

        this.result.addLn(indent + 1, "</div>");

        this.result.addLn(indent, "</div>");

    }

    private String obtainId() {
        if (this.mcQuestionAttributes.hasId()) return this.mcQuestionAttributes.getId();
        return "genId-" + UUID.randomUUID().toString();
    }

    private String getCssMCQuestionTypeClass() {
        return this.mcQuestionModel.getMcQuestionType().equals(MCQuestionModel.MCQuestionType.ONE) ? "m7r-mc-one" : "m7r-mc-multi";
    }

    private void renderTitle(int indent) {
        if (this.mcQuestionModel.hasTitle()) {
            this.result.addLn(indent + 2, "<h5 class=\"card-title\">" + this.mcQuestionModel.getTitle() + "</h5>");
        }
    }

    private void renderQuestionText(int indent) {
        this.result.addLn(indent + 2, "<p class=\"card-text\"><strong>" + this.mcQuestionModel.getQuestion() + "</strong></p>");
    }

    private void renderAnsweringOptions(int indent, String id) {
        List<MCQuestionAnsweringOption> mcQuestionAnsweringOptionList = this.mcQuestionModel.getMcQuestionAnsweringOptions();
        for (int index = 0; index < mcQuestionAnsweringOptionList.size(); index++) {
            MCQuestionAnsweringOption mcQuestionAnsweringOption = mcQuestionAnsweringOptionList.get(index);
            this.renderAnsweringOption(indent, id, index, mcQuestionAnsweringOption);
        }
    }

    private void renderAnsweringOption(int indent, String id, int index, MCQuestionAnsweringOption mcQuestionAnsweringOption) {

        String optionId = id + "_" + (index + 1);
        String cssCorrectClass = mcQuestionAnsweringOption.isCorrect() ? " m7r-mc-option-correct" : "";

        this.result.addLn(indent + 2, "<div id=\"" + optionId + "\" class=\"m7r-mc-option p-2 rounded mt-2" + cssCorrectClass + "\">");
        this.result.addLn(indent + 3, "<span class=\"m7r-mc-icon\"></span>");
        this.result.addLn(indent + 3, "<span class=\"ml-2\">" + mcQuestionAnsweringOption.getText() + "</span>");
        this.result.addLn(indent + 2, "</div>");
    }

    private void renderFeedbackButtonFooter(int indent) {

        this.result.addLn(indent + 2, "<div class=\"mt-4\">");

        renderFeedbackFail(indent);
        renderFeedbackSuccess(indent);
        renderButton(indent, "m7r-mc-button-check", "m7r-mc-icon-check", "Überprüfen");
        renderButton(indent, "m7r-mc-button-show", "m7r-mc-icon-show", "Lösung anzeigen");
        renderButton(indent, "m7r-mc-button-retry", "m7r-mc-icon-retry", "Wiederholen");

        this.result.addLn(indent + 2, "</div>");
    }

    private void renderFeedbackFail(int indent) {
        this.result.addLn(indent + 3, "<div class=\"m7r-mc-feedback-fail btn border border-danger text-danger font-weight-bold px-3 d-none\">");
        this.result.addLn(indent + 4, "<span class=\"m7r-mc-icon-fail\"></span>");
        this.result.addLn(indent + 4, "<span class=\"pl-2\">Leider falsch!</span>");
        this.result.addLn(indent + 3, "</div>");
    }

    private void renderFeedbackSuccess(int indent) {
        this.result.addLn(indent + 3, "<div class=\"m7r-mc-feedback-success btn border border-success text-success font-weight-bold px-3 d-none\">");
        this.result.addLn(indent + 4, "<span class=\"m7r-mc-icon-success\"></span>");
        this.result.addLn(indent + 4, "<span class=\"pl-2\">Richtig!</span>");
        this.result.addLn(indent + 3, "</div>");
    }

    private void renderButton(int indent, String cssButtonClass, String cssIconClass, String text) {
        this.result.addLn(indent + 3, "<button type=\"button\" class=\"" + cssButtonClass + " btn btn-primary px-3 d-none\">");
        this.result.addLn(indent + 4, "<span class=\"" + cssIconClass + " m7r-mc-icon-check\"></span>");
        this.result.addLn(indent + 4, "<span class=\"pl-2\">" + text + "</span>");
        this.result.addLn(indent + 3, "</button>");
    }
}
