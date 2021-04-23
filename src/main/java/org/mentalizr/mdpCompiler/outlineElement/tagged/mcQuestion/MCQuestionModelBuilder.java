package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion.MCQuestionModel.MCQuestionType;

import java.util.ArrayList;
import java.util.List;

public class MCQuestionModelBuilder extends OutlineElementTaggedModelBuilder {

    public MCQuestionModelBuilder() {
        super(new MCQuestion());
    }

    public MCQuestionModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof McQuestionExtraction))
            throw new RuntimeException(McQuestionExtraction.class.getSimpleName() + " expected.");

        if (extraction.isEmpty())
            throw new IllegalStateException("Insufficient number of lines.");

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        MCQuestionAttributes mcQuestionAttributes = (MCQuestionAttributes) mdpTag.getAttributes();

        List<Line> lines = extraction.getLines();

        String title = null;
        String question = "";

        List<MCQuestionAnsweringOption> mcQuestionAnsweringOptions = new ArrayList<>();

        for (int i=1; i<lines.size(); i++) {

            Line line = lines.get(i);
            String lineAsString = line.asString().substring(4);

            if (i == 1) {
                if (lineAsString.startsWith("+ ") || lineAsString.startsWith("- "))
                    throw new MDPSyntaxError(line, "Title or header expected for mc-question, but found answering option.");
                question = lineAsString;
            }

            if (i == 2) {
                if (notMarkedAsAnsweringOption(lineAsString)) {
                    title = question;
                    question = lineAsString;
                } else {
                    MCQuestionAnsweringOption mcQuestionAnsweringOption = parseAsAnsweringOption(line);
                    mcQuestionAnsweringOptions.add(mcQuestionAnsweringOption);
                }
            }

            if (i > 2) {
                MCQuestionAnsweringOption mcQuestionAnsweringOption = parseAsAnsweringOption(line);
                mcQuestionAnsweringOptions.add(mcQuestionAnsweringOption);
            }
        }

        int nrOfCorrectOptions = getNrOfCorrectOptions(mcQuestionAnsweringOptions);
        if (nrOfCorrectOptions == 0)
            throw new MDPSyntaxError(lines.get(0), "No answering option of mc-question marked as correct.");
        MCQuestionType mcQuestionType = getMCQuestionType(mcQuestionAttributes, nrOfCorrectOptions, extraction);

        MCQuestionModel mcQuestionModel = new MCQuestionModel(title, question, mcQuestionAnsweringOptions, mcQuestionType, mcQuestionAttributes);
        mcQuestionModel.setMdpTag(mdpTag);

        return mcQuestionModel;
    }

    private boolean notMarkedAsAnsweringOption(String content) {
        return (!content.startsWith("+ ") && !content.startsWith("- "));
    }

    private boolean markedAsCorrectOption(String content) {
        return (content.startsWith("+ "));
    }

    private MCQuestionAnsweringOption parseAsAnsweringOption(Line line) throws MDPSyntaxError {

        String content = line.asString().substring(4);

        if (notMarkedAsAnsweringOption(content))
            throw new MDPSyntaxError(line, "Malformed answering option for mc-question.");

        boolean correct = markedAsCorrectOption(content);
        String optionText = content.substring(2);

        return new MCQuestionAnsweringOption(optionText, correct);
    }

    private int getNrOfCorrectOptions(List<MCQuestionAnsweringOption> mcQuestionAnsweringOptionList) {

        int nrOfCorrectOptions = 0;

        for (MCQuestionAnsweringOption mcQuestionAnsweringOption : mcQuestionAnsweringOptionList) {
            if (mcQuestionAnsweringOption.isCorrect()) nrOfCorrectOptions++;
        }

        return nrOfCorrectOptions;
    }

    private MCQuestionType getMCQuestionType(MCQuestionAttributes mcQuestionAttributes, int nrOfCorrectOptions, Extraction extraction) throws MDPSyntaxError {

        if (mcQuestionAttributes.getType().equals(MCQuestionAttributes.TYPE_VALUE_AUTO)) {
            if (nrOfCorrectOptions == 1) {
                return MCQuestionType.ONE;
            } else {
                return MCQuestionType.MULTI;
            }
        } else if (mcQuestionAttributes.getType().equals(MCQuestionAttributes.TYPE_VALUE_ONE)) {
            if (nrOfCorrectOptions == 1) {
                return MCQuestionType.ONE;
            } else {
                throw new MDPSyntaxError(extraction.getTagLine(), "Illegal value for type '" + MCQuestionAttributes.TYPE_VALUE_ONE + "'. More than one answering options marked as correct.");
            }
        } else {
            return MCQuestionType.MULTI;
        }
    }

}
