package org.mentalizr.mdpCompiler.cli;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.mentalizr.mdpCompiler.cli.CompileConfiguration.CompileMode.FILE;

public class CompileConfiguration {

    public enum CompileMode {FILE, PROGRAM}

    private CompileMode compileMode;
    private boolean clean;
    private List<File> files;

    public CompileConfiguration() {
        this.compileMode = FILE;
        this.files = new ArrayList<>();
    }

    public void setCompileMode(CompileMode compileMode) {
        this.compileMode = compileMode;
    }

    public CompileMode getCompileMode() {
        return compileMode;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public boolean isClean() {
        return clean;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
