package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertExtraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertModelBuilder;

import java.util.List;

public class AudioModelBuilder implements OutlineElementModelBuilder {

    public AudioModelBuilder(AudioAttributes audioAttributes) {
    }

    @Override
    public AudioModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof AudioExtraction))
            throw new RuntimeException(AudioExtraction.class.getSimpleName() + " expected.");

        if (extraction.isEmpty())
            throw new IllegalStateException(this.getClass().getSimpleName() + ": Insufficient number of lines.");

        return new AudioModel();
    }

}
