package org.mentalizr.mdpCompiler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MDPSyntaxErrorCollector {

    public static class MDPSyntaxErrorWrapper {

        private final File mdpFile;
        private final MDPSyntaxError mdpSyntaxError;

        public MDPSyntaxErrorWrapper(File mdpFile, MDPSyntaxError mdpSyntaxError) {
            this.mdpSyntaxError = mdpSyntaxError;
            this.mdpFile = mdpFile;
        }

        public MDPSyntaxError getMdpSyntaxError() {
            return mdpSyntaxError;
        }

        public File getMdpFile() {
            return mdpFile;
        }
    }

    private final List<MDPSyntaxErrorWrapper> mdpSyntaxErrorWrapperList;

    public MDPSyntaxErrorCollector() {
        this.mdpSyntaxErrorWrapperList = new ArrayList<>();
    }

    public void add(File mdpFile, MDPSyntaxError mdpSyntaxError) {
        this.mdpSyntaxErrorWrapperList.add(new MDPSyntaxErrorWrapper(mdpFile, mdpSyntaxError));
    }

    public boolean isEmpty() {
        return this.mdpSyntaxErrorWrapperList.isEmpty();
    }

    public List<MDPSyntaxErrorWrapper> getMdpSyntaxErrorWrapperList() {
        return this.mdpSyntaxErrorWrapperList;
    }
}
