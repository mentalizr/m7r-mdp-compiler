package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class AudioRenderer extends OutlineElementRenderer {

//    private static final String CONTEXT_UR_AUDIO = "mediaAudio/";
//    private static final String CONTEXT_UR_AUDIO = "mediaVideo/";
    private static final String CONTEXT_UR_AUDIO = "mediaAV/";

    private final AudioAttributes audioAttributes;
    private final AudioModel audioModel;
    private final String mdpTagLink;

    public AudioRenderer(Result result, AudioAttributes audioAttributes, AudioModel audioModel, String mdpTagLink) {
        super(result);
        this.audioAttributes = audioAttributes;
        this.audioModel = audioModel;
        this.mdpTagLink = mdpTagLink;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        String marginTop = this.audioAttributes.getMarginTop();
        String marginBottom = this.audioAttributes.getMarginBottom();
        String source = compilerContext.getServiceContextURL() + CONTEXT_UR_AUDIO + this.mdpTagLink;

        this.result.addLn("<audio class=\"mt-" + marginTop + " mb-" + marginBottom + "\" preload=\"none\" style=\"width: 100%;\" controls=\"controls\">");
        this.result.addLn(1, "<source type=\"audio/mpeg\" src=\"" + source + "\"/>");
        this.result.addLn(1, "<a href=\"" + source + "\">" + source + "</a>");
        this.result.addLn("</audio>");
    }

}
