package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class MultiAudioRenderer extends OutlineElementRenderer {

    public MultiAudioRenderer() {
        super();
    }

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        MultiAudioModel multiAudioModel = (MultiAudioModel) outlineElementModel;
        MultiAudioAttributes audioAttributes = multiAudioModel.getAudioAttributes();
//        String mdpTagLink = multiAudioModel.getMdpTag().getLinkString();

        String marginTop = audioAttributes.getMarginTop();
        String marginBottom = audioAttributes.getMarginBottom();
//        String source = compilerContext.getMediaContextUrl() + mdpTagLink;

        htmlBuilder.addLn("<div class=\"m7r-ma defined-space container-lg d-flex flex-column\">");
        htmlBuilder.addLn(1,"<div class=\"audio-player-toolbar p-1 d-flex flex-column align-items-center\">");
        htmlBuilder.addLn(2, "<i id=\"m7r-ma-play-pause-button\" class=\"bi-play-circle\"></i>");
        htmlBuilder.addLn(1, "</div>");
        htmlBuilder.addLn(1, "<div class=\"slider-container p-2 d-flex flex-column align-self-center w-100\">");
        htmlBuilder.addLn(2, "<div class=\"slider-toolbar d-flex flex-row justify-content-between\">");
        htmlBuilder.addLn(3, "<div class=\"d-flex flex-row align-items-center\">");
        htmlBuilder.addLn(4, "<i id=\"rewind-button\" class=\"bi bi-rewind\"></i>");
        htmlBuilder.addLn(4, "<i id=\"loop-button\" class=\"bi bi-repeat\"></i>");
        htmlBuilder.addLn(3, "</div>");
        htmlBuilder.addLn(3, "<div class=\"d-flex flex-row align-items-center justify-content-end\">");
        htmlBuilder.addLn(4, "<input id=\"volume-slider\" type=\"range\" min=\"0\" max=\"100\" value=\"100\" class=\"p-1 w-50\">");
        htmlBuilder.addLn(4, "<i id=\"volume-button\" class=\"p-2 bi-volume-down\"></i>");
        htmlBuilder.addLn(3, "</div>");
        htmlBuilder.addLn(2, "</div>");
        htmlBuilder.addLn(2, "<div class=\"d-flex flex-column\">");
        htmlBuilder.addLn(3, "<input type=\"range\" id=\"progressBar\" min=\"0\" value=\"0\" class=\"p-1\" max=\"660\">");
        htmlBuilder.addLn(3, "<div class=\"slider-timestamp p-2 d-flex flex-row justify-content-between\">");
        htmlBuilder.addLn(4, "<label id=\"current-time-label\">0:28</label>");
        htmlBuilder.addLn(4, "<label id=\"remaining-time-label\">10:32</label>");
        htmlBuilder.addLn(3, "</div>");
        htmlBuilder.addLn(2, "</div>");
        htmlBuilder.addLn(1, "</div>");
        htmlBuilder.addLn(1, "<div role=\"group\" class=\"audio-player-playlist btn-group-vertical p-3 align-items-center\">");
        htmlBuilder.addLn(2, "<button class=\"btn btn-secondary w-25 active\" style=\"min-width: 130px;\">Klavier</button>");
        htmlBuilder.addLn(2, "<button class=\"btn btn-secondary w-25\" style=\"min-width: 130px;\">Monochord</button>");
        htmlBuilder.addLn(2, "<button class=\"btn btn-secondary w-25\" style=\"min-width: 130px;\">Dritte V.</button>");
        htmlBuilder.addLn(1, "</div>");
        htmlBuilder.addLn("</div>");


//        htmlBuilder.addLn("<audio class=\"mt-" + marginTop + " mb-" + marginBottom + "\" preload=\"none\" style=\"width: 100%;\" controls=\"controls\">");
//        htmlBuilder.addLn(1, "<source type=\"audio/mpeg\" src=\"" + source + "\"/>");
//        htmlBuilder.addLn(1, "<a href=\"" + source + "\">" + source + "</a>");
//        htmlBuilder.addLn("</audio>");
    }

}
