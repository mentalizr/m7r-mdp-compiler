package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion.MCQuestionAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio.MultiAudioModel.MultiAudioResource;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiAudioModelBuilderTest {

    @Test
    void buildTest() throws MDPSyntaxError {

        Document document = new Document(
                "@multi-audio[]",
                "    [label1](source1.mp3)",
                "    [label2](source2.mp3)",
                "    [label3](source3.mp3)"
        );
        Extraction extraction = new MultiAudioExtraction(document);

        MultiAudioModel multiAudioModel = new MultiAudioModelBuilder().getModel(extraction);

        List<MultiAudioResource> multiAudioResources = multiAudioModel.getAudioResources();
        assertEquals(3, multiAudioResources.size());
        assertEquals("label1", multiAudioResources.get(0).label());
        assertEquals("source1.mp3", multiAudioResources.get(0).source());
        assertEquals("label2", multiAudioResources.get(1).label());
        assertEquals("source2.mp3", multiAudioResources.get(1).source());
        assertEquals("label3", multiAudioResources.get(2).label());
        assertEquals("source3.mp3", multiAudioResources.get(2).source());

        Set<String> mediaResources = multiAudioModel.getMediaResources();
        assertEquals(3, mediaResources.size());
        assertTrue(mediaResources.contains("source1.mp3"));
        assertTrue(mediaResources.contains("source2.mp3"));
        assertTrue(mediaResources.contains("source3.mp3"));
    }

}
