package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

public class VideoModelBuilder extends OutlineElementTaggedModelBuilder {

    public VideoModelBuilder() {
        super(new Video());
    }

    @Override
    public VideoModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof VideoExtraction))
            throw new RuntimeException(VideoExtraction.class.getSimpleName() + " expected.");

        VideoModel videoModel = new VideoModel();

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        videoModel.setMdpTag(mdpTag);

        return videoModel;
    }

}
