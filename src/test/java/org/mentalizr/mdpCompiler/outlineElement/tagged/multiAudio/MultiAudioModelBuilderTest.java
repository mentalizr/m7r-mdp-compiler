package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MultiAudioModelBuilderTest {

    @Test
    void buildTest() throws MDPSyntaxError {

        String mdpLine = "@multi-audio[](track1.mp3;track2.mp3;track3.mp3)";
        Extraction extraction = new MultiAudioExtraction(Lines.create(mdpLine));

        MultiAudioModel multiAudioModel = new MultiAudioModelBuilder().getModel(extraction);

        Set<String> mediaResources = multiAudioModel.getMediaResources();
        List<String> mediaResourcesList = new ArrayList<>(mediaResources);

        assertEquals(3, mediaResourcesList.size());
        assertEquals("track1.mp3", mediaResourcesList.get(0));
        assertEquals("track2.mp3", mediaResourcesList.get(1));
        assertEquals("track3.mp3", mediaResourcesList.get(2));
    }

}
