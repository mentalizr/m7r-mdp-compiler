package org.mentalizr.mdpCompiler.outlineElement.exception;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;

public class ElementAlreadyInitializedException extends MDPSyntaxError {

    public ElementAlreadyInitializedException(Line line, String tagName) {
        super(line, "[" + tagName + "] schon initialisiert.");

    }
}
