package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio.MultiAudioModel.MultiAudioResource;

import java.util.*;

public class MultiAudioModelBuilder extends OutlineElementTaggedModelBuilder {

    private static final String malformedTrackMessage = "Malformed " + MultiAudio.TAG + " track reference.";

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
        MultiAudioAttributes multiAudioAttributes = (MultiAudioAttributes) mdpTag.getAttributes();

        List<MultiAudioResource> multiMultiAudioResources = new ArrayList<>();
        List<Line> lines = extraction.getLines();
        for (int i=1; i<lines.size(); i++) {
            MultiAudioResource multiAudioResource = getMultiAudioResource(lines, i);
            assertSourceNotSpecifiedYet(multiMultiAudioResources, multiAudioResource, lines.get(i));
            multiMultiAudioResources.add(multiAudioResource);
        }
        if (multiMultiAudioResources.isEmpty())
            throw new MDPSyntaxError(extraction.getTagLine(), "No track definitions found.");

        MultiAudioModel multiAudioModel = new MultiAudioModel(multiMultiAudioResources, multiAudioAttributes);
        multiAudioModel.setMdpTag(mdpTag);

        return multiAudioModel;
    }

    private static MultiAudioResource getMultiAudioResource(List<Line> lines, int i) throws MDPSyntaxError {
        Line line = lines.get(i);
        String lineAsString = line.asString().substring(4);

        if (!lineAsString.startsWith("[") || !lineAsString.endsWith(")"))
            throw new MDPSyntaxError(line, malformedTrackMessage);

        lineAsString = lineAsString.substring(1, lineAsString.length() - 1);
        String[] splitLineArray = lineAsString.split("]\\(");
        if (splitLineArray.length != 2) throw new MDPSyntaxError(line, malformedTrackMessage);

        String label = splitLineArray[0].trim();
        String source = splitLineArray[1].trim();

        return new MultiAudioResource(label, source);
    }

    private static void assertSourceNotSpecifiedYet(
            List<MultiAudioResource> multiAudioResources,
            MultiAudioResource multiAudioResourceToBeAdded,
            Line line) throws MDPSyntaxError {

        Optional<String> preexistingResource
                = multiAudioResources.stream()
                .map(MultiAudioResource::source)
                .filter(s -> s.equals(multiAudioResourceToBeAdded.source()))
                .findFirst();
        if (preexistingResource.isPresent())
            throw new MDPSyntaxError(line, "Source of track definition is already specified.");
    }

}
