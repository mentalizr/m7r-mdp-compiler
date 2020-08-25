package org.mentalizr.mdpCompiler.outlineElement.md.table;

public class TableModelException extends Exception {

    public TableModelException() {
    }

    public TableModelException(String message) {
        super(message);
    }

    public TableModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableModelException(Throwable cause) {
        super(cause);
    }

    public TableModelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
