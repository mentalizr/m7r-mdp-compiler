package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.List;

public class MCQuestionModel extends OutlineElementTaggedModel {

    public enum MCQuestionType {ONE, MULTI}

    private final String title;
    private final String question;
    private final MCQuestionType mcQuestionType;
    private final MCQuestionAttributes mcQuestionAttributes;

    private final List<MCQuestionAnsweringOption> mcQuestionAnsweringOptions;

    public MCQuestionModel(
            String title,
            String question,
            List<MCQuestionAnsweringOption> mcQuestionAnsweringOptions,
            MCQuestionType mcQuestionType,
            MCQuestionAttributes mcQuestionAttributes) {
        super(new MCQuestion());
        this.title = title;
        this.question = question;
        this.mcQuestionAnsweringOptions = mcQuestionAnsweringOptions;
        this.mcQuestionType = mcQuestionType;
        this.mcQuestionAttributes = mcQuestionAttributes;
    }

    public boolean hasTitle() {
        return this.title != null;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public List<MCQuestionAnsweringOption> getMcQuestionAnsweringOptions() {
        return mcQuestionAnsweringOptions;
    }

    public MCQuestionType getMcQuestionType() {
        return this.mcQuestionType;
    }

    public MCQuestionAttributes getMcQuestionAttributes() {
        return mcQuestionAttributes;
    }
}
