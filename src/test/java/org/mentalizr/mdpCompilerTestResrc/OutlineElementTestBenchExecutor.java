package org.mentalizr.mdpCompilerTestResrc;

import de.arthurpicht.utils.core.collection.Sets;
import org.mentalizr.mdpCompiler.helper.TextFile;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class OutlineElementTestBenchExecutor {

    private final OutlineElement outlineElement;
    private String[] mdpLines;
    private String[] expectedLines;
    private int expectedDocumentIteratorIndex = -1;
    private Set<String> expectedMediaResources = null;

    public OutlineElementTestBenchExecutor(OutlineElement outlineElement) {
        this.outlineElement = outlineElement;
    }

    public OutlineElement getOutlineElement() {
        return this.outlineElement;
    }

    public OutlineElementTestBenchExecutor withMDPLines(String... mdpLines) {
        this.mdpLines = mdpLines;
        return this;
    }

    public OutlineElementTestBenchExecutor withMDPFile(File file) {
        try {
            this.mdpLines = TextFile.getLinesAsStrings(file).toArray(new String[0]);
            return this;
        } catch (IOException e) {
            throw new RuntimeException("Exception when opening MDP file '" + file.getAbsolutePath() + "': " + e.getMessage());
        }
    }

    public OutlineElementTestBenchExecutor withExpectedLines(String... expectedLines) {
        this.expectedLines = expectedLines;
        return this;
    }

    public OutlineElementTestBenchExecutor withExpectedFile(File file) {
        try {
            this.expectedLines = TextFile.getLinesAsStrings(file).toArray(new String[0]);
            return this;
        } catch (IOException e) {
            throw new RuntimeException("Exception when opening expected file '" + file.getAbsolutePath() + "': " + e.getMessage());
        }
    }

    public OutlineElementTestBenchExecutor withExpectedDocumentIteratorIndex(int expectedDocumentIteratorIndex) {
        this.expectedDocumentIteratorIndex = expectedDocumentIteratorIndex;
        return this;
    }

    public OutlineElementTestBenchExecutor withMediaResources(String... mediaResourcesArray) {
        this.expectedMediaResources = Set.of(mediaResourcesArray);
        return this;
    }

    public String[] getMdpLines() {
        if (this.mdpLines == null || this.mdpLines.length == 0) throw new RuntimeException("No mdp lines specified.");
        return this.mdpLines;
    }

    public String[] getExpectedLines() {
        if (this.expectedLines == null || this.expectedLines.length == 0)
            throw new RuntimeException("No expected lines specified.");
        return this.expectedLines;
    }

    public boolean hasExpectedDocumentIteratorIndex() {
        return this.expectedDocumentIteratorIndex >= 0;
    }

    public int getExpectedDocumentIteratorIndex() {
        if (this.expectedDocumentIteratorIndex < 0)
            throw new RuntimeException("No expectedDocumentIteratorIndex specified.");
        return this.expectedDocumentIteratorIndex;
    }

    public boolean hasExpectedMediaResources() {
        return this.expectedMediaResources != null;
    }

    public Set<String> getExpectedMediaResources() {
        if (this.expectedMediaResources == null)
            throw new RuntimeException("No expectedMediaResources specified.");
        return this.expectedMediaResources;
    }

}
