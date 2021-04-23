package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class VideoFactory extends OutlineElementFactory {

    public VideoFactory() {
        super(Video.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new Video();
    }
}
