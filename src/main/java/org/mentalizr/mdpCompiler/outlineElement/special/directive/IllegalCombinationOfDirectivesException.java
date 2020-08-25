package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;

import java.util.Arrays;
import java.util.List;

public class IllegalCombinationOfDirectivesException extends MDPSyntaxError {

    private final String[] directives;

    public IllegalCombinationOfDirectivesException(Line line, String... directives) {
        super(line, "Illegal combination of directives: " + Strings.listing(Arrays.asList(directives), ", ") + ".");
        this.directives = directives;
    }

    public List<String> getDirectives() {
        return Arrays.asList(this.directives);
    }
}
