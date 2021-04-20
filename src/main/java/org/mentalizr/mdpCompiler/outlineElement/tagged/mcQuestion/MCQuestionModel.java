package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.List;

public class MCQuestionModel extends OutlineElementModel {

    public enum MCQuestionType {ONE, MULTI}

    private final String title;
    private final String question;
    private final MCQuestionType mcQuestionType;

    private final List<MCQuestionAnsweringOption> mcQuestionAnsweringOptions;

    public MCQuestionModel(String title, String question, List<MCQuestionAnsweringOption> mcQuestionAnsweringOptions, MCQuestionType mcQuestionType) {
        this.title = title;
        this.question = question;
        this.mcQuestionAnsweringOptions = mcQuestionAnsweringOptions;
        this.mcQuestionType = mcQuestionType;
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
}
