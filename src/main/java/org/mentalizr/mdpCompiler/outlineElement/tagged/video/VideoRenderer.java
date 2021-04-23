package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class VideoRenderer extends OutlineElementRenderer {

    private static final String CONTEXT_URL_VIDEO = "mediaAV/";
    private static final String CONTEXT_URL_IMG = "mediaImg/";

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        VideoModel videoModel = (VideoModel) outlineElementModel;
        VideoAttributes videoAttributes = videoModel.getVideoAttributes();
        String mdpTagLink = videoModel.getMdpTag().getLinkString();

        String marginTop = videoAttributes.getMarginTop();
        String marginBottom = videoAttributes.getMarginBottom();

        result.addLn("<div class=\"embed-responsive embed-responsive-16by9 mt-" + marginTop + " mb-" + marginBottom + "\">");

        String poster = "";
        if (videoAttributes.hasPoster()) {
            poster = " poster=\"" + compilerContext.getServiceContextURL() + CONTEXT_URL_IMG + videoAttributes.getPoster() + "\"";
        }

        String srcValue = compilerContext.getServiceContextURL() + CONTEXT_URL_VIDEO + mdpTagLink;

        result.addLn("    <video class=\"\" preload=\"metadata\" controls=\"true\"" + poster + " src=\"" + srcValue + "\" onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\"></video>");
        result.addLn("</div>");
    }

}
