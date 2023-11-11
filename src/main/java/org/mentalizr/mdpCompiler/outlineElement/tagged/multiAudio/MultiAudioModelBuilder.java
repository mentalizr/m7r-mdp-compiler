package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class MultiAudioModelBuilder extends OutlineElementTaggedModelBuilder {

    public MultiAudioModelBuilder() {
        super(new MultiAudio());
    }

    @Override
    public MultiAudioModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof MultiAudioExtraction))
            throw new RuntimeException(MultiAudioExtraction.class.getSimpleName() + " expected.");

        if (extraction.isEmpty())
            throw new IllegalStateException(this.getClass().getSimpleName() + ": Insufficient number of lines.");

        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());
        String mdpTagLinkString = mdpTag.getLinkString();
        String[] audioResources = mdpTagLinkString.split(";");
        LinkedHashSet<String> audioResourcesSet = new LinkedHashSet<>(Arrays.asList(audioResources));

        MultiAudioModel multiAudioModel = new MultiAudioModel(audioResourcesSet);
        multiAudioModel.setMdpTag(mdpTag);

        return multiAudioModel;
    }

}
