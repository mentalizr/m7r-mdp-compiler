package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;

public class AudioExtractor extends MDPTagOnlyExtractor {

    public AudioExtractor() {
        super(new AudioExtractionFactory());
    }

}
