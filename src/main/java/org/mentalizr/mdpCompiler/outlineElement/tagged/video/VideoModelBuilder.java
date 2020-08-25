package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class VideoModelBuilder implements OutlineElementModelBuilder {

    public VideoModelBuilder(VideoAttributes videoAttributes, List<Line> lines) {
    }

    @Override
    public VideoModel getModel() throws MDPSyntaxError {
        return new VideoModel();
    }

}
