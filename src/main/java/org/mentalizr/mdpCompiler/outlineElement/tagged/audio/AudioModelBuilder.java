package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

public class AudioModelBuilder extends OutlineElementTaggedModelBuilder {

    public AudioModelBuilder() {
        super(new Audio());
    }

    @Override
    public AudioModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof AudioExtraction))
            throw new RuntimeException(AudioExtraction.class.getSimpleName() + " expected.");

        if (extraction.isEmpty())
            throw new IllegalStateException(this.getClass().getSimpleName() + ": Insufficient number of lines.");

        AudioModel audioModel = new AudioModel();

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        audioModel.setMdpTag(mdpTag);

        return audioModel;
    }

}
