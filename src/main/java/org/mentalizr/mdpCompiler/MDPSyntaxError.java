package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.document.Line;

public class MDPSyntaxError extends Exception {

    protected Line line;

    public MDPSyntaxError(Line line, String message) {
        super(message);
        this.line = line;
    }

//    public MDPSyntaxError(Line line, String message, Throwable cause) {
//        super(message, cause);
//        this.line = line;
//    }

    public MDPSyntaxError(Line line, Throwable cause) {
        super(cause.getMessage(), cause);
        this.line = line;
    }

    public Line getLine() {
        return this.line;
    }
}
