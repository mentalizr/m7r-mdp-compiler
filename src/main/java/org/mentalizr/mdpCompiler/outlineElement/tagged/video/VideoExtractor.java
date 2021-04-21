package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.audio.AudioExtractionFactory;

public class VideoExtractor extends MDPTagOnlyExtractor {

    public VideoExtractor() {
        super(new VideoExtractionFactory());
    }

}
