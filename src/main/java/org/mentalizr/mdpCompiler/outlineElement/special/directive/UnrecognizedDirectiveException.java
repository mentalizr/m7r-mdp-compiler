package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;

public class UnrecognizedDirectiveException extends MDPSyntaxError {

    private final String directive;

    public UnrecognizedDirectiveException(Line line, String directive) {
        super(line, "Unrecognized directive: " + directive + ".");
        this.directive = directive;
    }

    public String getDirective() {
        return this.directive;
    }
}
