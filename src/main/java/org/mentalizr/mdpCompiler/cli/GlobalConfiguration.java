package org.mentalizr.mdpCompiler.cli;

public class GlobalConfiguration {

    public enum VerbosityLevel { SILENT, NORMAL, VERBOSE}

    private VerbosityLevel verbosityLevel;
    private boolean showStacktrace;

    public GlobalConfiguration() {
        this.verbosityLevel = VerbosityLevel.NORMAL;
        this.showStacktrace = false;
    }

    public void setVerbosityLevel(VerbosityLevel verbosityLevel) {
        this.verbosityLevel = verbosityLevel;
    }

    public VerbosityLevel getVerbosityLevel() {
        return this.verbosityLevel;
    }

    public boolean isShowStacktrace() {
        return showStacktrace;
    }

    public void setShowStacktrace(boolean showStacktrace) {
        this.showStacktrace = showStacktrace;
    }
}
