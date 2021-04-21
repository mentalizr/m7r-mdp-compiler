package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertExtraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectiveModelBuilder implements OutlineElementModelBuilder {

    public static final String DIRECTIVE_NAME = "@@name";
    public static final String DIRECTIVE_PERSISTENT = "@@persistent";
    public static final String DIRECTIVE_EXERCISE = "@@exercise";
    public static final String DIRECTIVE_FEEDBACK = "@@feedback";

//    private final List<Line> lines;
//
//    private DirectiveModel directiveModel;

    public DirectiveModelBuilder() {
//        this.lines = Lines.shallowCopy(lines);
//        this.directiveModel = null;
    }

    @Override
    public OutlineElementModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof DirectiveExtraction))
            throw new RuntimeException(DirectiveExtraction.class.getSimpleName() + " expected.");

        validate(extraction);

        List<String> directiveLines = new ArrayList<>();

        for (Line line : extraction.getLines()) {
            directiveLines.add(line.asString());
        }

        return new DirectiveModel(directiveLines);
    }

    private void validate(Extraction extraction) throws MDPSyntaxError {

        List<String> possibleDirectiveList = Arrays.asList(DIRECTIVE_PERSISTENT, DIRECTIVE_EXERCISE, DIRECTIVE_FEEDBACK);

        boolean hasDirectivePersistent = false;
        boolean hasDirectiveExercise = false;
        boolean hasDirectiveFeedback = false;

        for (Line line : extraction.getLines()) {

            String lineAsString = line.asString();

            if (lineAsString.startsWith(DIRECTIVE_NAME + "=")) continue;

            if (!containsOneOf(lineAsString, possibleDirectiveList))
                throw new UnrecognizedDirectiveException(line, lineAsString);

            if (lineAsString.trim().equals(DIRECTIVE_PERSISTENT)) hasDirectivePersistent = true;
            if (lineAsString.trim().equals(DIRECTIVE_EXERCISE)) hasDirectiveExercise = true;
            if (lineAsString.trim().equals(DIRECTIVE_FEEDBACK)) hasDirectiveFeedback = true;

            if (hasDirectivePersistent && hasDirectiveExercise) {
                throw new IllegalCombinationOfDirectivesException(line, DIRECTIVE_PERSISTENT, DIRECTIVE_EXERCISE);
            }

            if (hasDirectivePersistent && hasDirectiveFeedback) {
                throw new IllegalCombinationOfDirectivesException(line, DIRECTIVE_PERSISTENT, DIRECTIVE_FEEDBACK);
            }

        }

    }

    private boolean containsOneOf(String string, List<String> list) {
        for (String listElement : list) {
            if (string.contains(listElement)) return true;
        }
        return false;
    }
}
