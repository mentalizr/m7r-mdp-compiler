package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertExtraction;

import java.util.List;

public class VideoModelBuilder implements OutlineElementModelBuilder {

    public VideoModelBuilder(VideoAttributes videoAttributes) {
    }

    @Override
    public VideoModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof VideoExtraction))
            throw new RuntimeException(VideoExtraction.class.getSimpleName() + " expected.");

        return new VideoModel();
    }

}
