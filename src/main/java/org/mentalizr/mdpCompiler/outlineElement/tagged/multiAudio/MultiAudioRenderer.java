package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio.MultiAudioModel.MultiAudioResource;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.util.List;
import java.util.UUID;

public class MultiAudioRenderer extends OutlineElementRenderer {

    public MultiAudioRenderer() {
        super();
    }

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        MultiAudioModel multiAudioModel = (MultiAudioModel) outlineElementModel;
        MultiAudioAttributes multiAudioAttributes = multiAudioModel.getMultiAudioAttributes();

        String id = obtainId(multiAudioAttributes);
        String marginTop = multiAudioAttributes.getMarginTop();
        String marginBottom = multiAudioAttributes.getMarginBottom();

        int indent = compilerContext.getIndentLevel();

        htmlBuilder.addLn(indent, "<div id=\"" + id + "\" class=\"m7r-ma container-fluid col-lg-8 col-md-10 col-sm-12 col-xs-12 mt-" + marginTop
                + " mb-" + marginBottom + " d-flex flex-column\">");
        htmlBuilder.addLn(indent + 1, "<div class=\"m7r-ma-toolbar p-1 d-flex flex-column align-items-center\">");
        htmlBuilder.addLn(indent + 2, "<i class=\"m7r-ma-play-pause-button bi-play-circle\"></i>");
        htmlBuilder.addLn(indent + 1, "</div>");
        htmlBuilder.addLn(indent + 1, "<div class=\"slider-container p-2 d-flex flex-column align-self-center w-100\">");
        htmlBuilder.addLn(indent + 2, "<div class=\"slider-toolbar d-flex flex-row justify-content-between\">");
        htmlBuilder.addLn(indent + 3, "<div class=\"d-flex flex-row align-items-center\">");
        htmlBuilder.addLn(indent + 4, "<i class=\"m7r-ma-skip-back-button bi bi-rewind\"></i>");
        htmlBuilder.addLn(indent + 4, "<i class=\"m7r-ma-loop-button bi bi-repeat\"></i>");
        htmlBuilder.addLn(indent + 3, "</div>");
        htmlBuilder.addLn(indent + 3, "<div class=\"d-flex flex-row align-items-center justify-content-end\">");
        htmlBuilder.addLn(indent + 4, "<input class=\"m7r-ma-volume-slider p-1 w-50\" type=\"range\" min=\"0\" max=\"100\" value=\"100\">");
        htmlBuilder.addLn(indent + 4, "<i class=\"m7r-ma-mute-button p-2 bi-volume-down\"></i>");
        htmlBuilder.addLn(indent + 3, "</div>");
        htmlBuilder.addLn(indent + 2, "</div>");
        htmlBuilder.addLn(indent + 2, "<div class=\"d-flex flex-column\">");
        htmlBuilder.addLn(indent + 3, "<input type=\"range\" class=\"m7r-ma-progressBar p-1\" min=\"0\" value=\"0\" max=\"1000\">");
        htmlBuilder.addLn(indent + 3, "<div class=\"slider-timestamp p-2 d-flex flex-row justify-content-between\">");
        htmlBuilder.addLn(indent + 4, "<label class=\"m7r-ma-current-time-label\">0:00</label>");
        htmlBuilder.addLn(indent + 4, "<label class=\"m7r-ma-remaining-time-label\">0:00</label>");
        htmlBuilder.addLn(indent + 3, "</div>");
        htmlBuilder.addLn(indent + 2, "</div>");
        htmlBuilder.addLn(indent + 1, "</div>");
        htmlBuilder.addLn(indent + 1, "<div role=\"group\" class=\"m7r-ma-playlist btn-group-vertical p-3 align-items-center\">");
        generateTrackButtons(multiAudioModel.getAudioResources(), indent, htmlBuilder);
        htmlBuilder.addLn(indent + 1, "</div>");
        htmlBuilder.addLn(indent, "</div>");
    }

    private static void generateTrackButtons(
            List<MultiAudioResource> multiAudioResourceList,
            int indent,
            HtmlBuilder htmlBuilder) {

        boolean first = true;
        for (MultiAudioResource multiAudioResource : multiAudioResourceList) {
            String html = "<button class=\"m7r-ma-track-button btn btn-secondary w-25";
            if (first) {
                html += " active";
                first = false;
            }
            html += "\" data-source=\"media/" + multiAudioResource.source() + "\">" + multiAudioResource.label()
                    + "</button>";
            htmlBuilder.addLn(indent + 2, html);
        }
    }

    private static String obtainId(MultiAudioAttributes multiAudioAttributes) {
        if (multiAudioAttributes.hasId()) return multiAudioAttributes.getId();
        return "genId-" + UUID.randomUUID();
    }

}
