package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class VideoRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        VideoModel videoModel = (VideoModel) outlineElementModel;
        VideoAttributes videoAttributes = videoModel.getVideoAttributes();
        String mdpTagLink = videoModel.getMdpTag().getLinkString();

        String marginTop = videoAttributes.getMarginTop();
        String marginBottom = videoAttributes.getMarginBottom();
        int indentLevel = compilerContext.getIndentLevel();

        htmlBuilder.addLn(indentLevel, "<div class=\"embed-responsive embed-responsive-16by9 mt-" + marginTop + " mb-" + marginBottom + "\">");

        String poster = "";
        if (videoAttributes.hasPoster()) {
            poster = " poster=\"" + compilerContext.getMediaContextUrl() + videoAttributes.getPoster() + "\"";
        }

        String srcValue = compilerContext.getMediaContextUrl() + mdpTagLink;

        htmlBuilder.addLn("    <video class=\"\" preload=\"metadata\" controls=\"true\"" + poster + " onclick=\"this.paused?this.play():this.pause();\" allowfullscreen=\"\" playsinline=\"\">");
        htmlBuilder.addLn("        <source src=\"" + srcValue + "\" type=\"video/mp4\"/>");
        htmlBuilder.addLn("    </video>");
        htmlBuilder.addLn("</div>");
    }

}
