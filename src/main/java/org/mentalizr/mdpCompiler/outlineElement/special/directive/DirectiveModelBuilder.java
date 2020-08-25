package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectiveModelBuilder implements OutlineElementModelBuilder {

    public static final String DIRECTIVE_NAME = "@@name";
    public static final String DIRECTIVE_PERSISTENT = "@@persistent";
    public static final String DIRECTIVE_EXERCISE = "@@exercise";
    public static final String DIRECTIVE_FEEDBACK = "@@feedback";

    private final List<Line> lines;

    private DirectiveModel directiveModel;

    public DirectiveModelBuilder(List<Line> lines) {
        this.lines = Lines.shallowCopy(lines);
        this.directiveModel = null;
    }

    @Override
    public OutlineElementModel getModel() throws MDPSyntaxError {

        if (this.directiveModel == null) {
            buildModel();
        }
        return this.directiveModel;
    }

    private void buildModel() throws MDPSyntaxError {

        validate();

        List<String> directiveLines = new ArrayList<>();

        for (Line line : this.lines) {
            directiveLines.add(line.asString());
        }

        this.directiveModel = new DirectiveModel(directiveLines);
    }

    private void validate() throws MDPSyntaxError {

        List<String> possibleDirectiveList = Arrays.asList(DIRECTIVE_PERSISTENT, DIRECTIVE_EXERCISE, DIRECTIVE_FEEDBACK);

        boolean hasDirectivePersistent = false;
        boolean hasDirectiveExercise = false;
        boolean hasDirectiveFeedback = false;

        for (Line line : this.lines) {

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
