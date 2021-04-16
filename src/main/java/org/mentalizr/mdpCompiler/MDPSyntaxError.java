package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.document.Line;

import java.nio.file.Path;

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

    public static String getExtendedMessage(Path path, MDPSyntaxError mdpSyntaxError) {
        return "Syntax error in [" + path.toAbsolutePath() + ":" + mdpSyntaxError.getLine().getLineNr() + "] " + mdpSyntaxError.getMessage();
    }

    public static String getExtendedMessage(String id, MDPSyntaxError mdpSyntaxError) {
        return "Syntax error in [" + id + ":" + mdpSyntaxError.getLine().getLineNr() + "] " + mdpSyntaxError.getMessage();
    }

}
