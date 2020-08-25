package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class AudioModelBuilder implements OutlineElementModelBuilder {

    public AudioModelBuilder(AudioAttributes videoAttributes, List<Line> lines) {
    }

    @Override
    public AudioModel getModel() throws MDPSyntaxError {
        return new AudioModel();
    }

}
