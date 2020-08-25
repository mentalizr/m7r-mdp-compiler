package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

public class MCQuestionAnsweringOption {

    private final String text;
    private final boolean correct;

    public MCQuestionAnsweringOption(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }
}
