package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class VideoFactory extends OutlineElementFactory {

    public VideoFactory() {
        super(Video.TAG);
    }

    @Override
    public OutlineElement getInstance(Line tagLine) throws MDPSyntaxError {
        return new Video(tagLine);
    }
}
