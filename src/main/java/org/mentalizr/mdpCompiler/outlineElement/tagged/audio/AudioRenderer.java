package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class AudioRenderer extends OutlineElementRenderer {

    private static final String CONTEXT_UR_AUDIO = "mediaAV/";

    public AudioRenderer() {
        super();
    }

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        AudioModel audioModel = (AudioModel) outlineElementModel;
        AudioAttributes audioAttributes = audioModel.getAudioAttributes();
        String mdpTagLink = audioModel.getMdpTag().getLinkString();

        String marginTop = audioAttributes.getMarginTop();
        String marginBottom = audioAttributes.getMarginBottom();
        String source = compilerContext.getServiceContextURL() + CONTEXT_UR_AUDIO + mdpTagLink;

        result.addLn("<audio class=\"mt-" + marginTop + " mb-" + marginBottom + "\" preload=\"none\" style=\"width: 100%;\" controls=\"controls\">");
        result.addLn(1, "<source type=\"audio/mpeg\" src=\"" + source + "\"/>");
        result.addLn(1, "<a href=\"" + source + "\">" + source + "</a>");
        result.addLn("</audio>");
    }

}
