package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class VideoRenderer extends OutlineElementRenderer {

//    private static final String CONTEXT_URL_VIDEO = "mediaVideo/";
    private static final String CONTEXT_URL_VIDEO = "mediaAV/";
    private static final String CONTEXT_URL_IMG = "mediaImg/";

    private final VideoAttributes videoAttributes;
    private final VideoModel videoModel;
    private final String mdpTagLink;

    public VideoRenderer(Result result, VideoAttributes videoAttributes, VideoModel videoModel, String mdpTagLink) {
        super(result);
        this.videoAttributes = videoAttributes;
        this.videoModel = videoModel;
        this.mdpTagLink = mdpTagLink;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

//        String style = " style=\"";
//
//        style += "margin-top: " + this.videoAttributes.getMarginTop() + "em; ";
//        style += "margin-bottom: " + this.videoAttributes.getMarginBottom() + "em";
//        style += "\"";
//
//        this.result.addLn("<div class=\"embed-responsive embed-responsive-16by9\"" + style + ">");

        String marginTop = this.videoAttributes.getMarginTop();
        String marginBottom = this.videoAttributes.getMarginBottom();

        this.result.addLn("<div class=\"embed-responsive embed-responsive-16by9 mt-" + marginTop + " mb-" + marginBottom + "\">");

        String poster = "";
        if (this.videoAttributes.hasPoster()) {
            poster = " poster=\"" + compilerContext.getServiceContextURL() + CONTEXT_URL_IMG + this.videoAttributes.getPoster() + "\"";
        }

        String srcValue = compilerContext.getServiceContextURL() + CONTEXT_URL_VIDEO + this.mdpTagLink;

        this.result.addLn("    <video class=\"\" preload=\"metadata\" controls=\"true\"" + poster + " src=\"" + srcValue + "\" onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\"></video>");
        this.result.addLn("</div>");

    }
}
