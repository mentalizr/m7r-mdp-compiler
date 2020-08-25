package org.mentalizr.mdpCompiler.cli;

public class FileSystemCheckerException extends Exception {

    public FileSystemCheckerException() {
    }

    public FileSystemCheckerException(String message) {
        super(message);
    }

    public FileSystemCheckerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSystemCheckerException(Throwable cause) {
        super(cause);
    }

    public FileSystemCheckerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
