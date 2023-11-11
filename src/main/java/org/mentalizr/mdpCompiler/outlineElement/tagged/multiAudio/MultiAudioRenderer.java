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
        String mdpTagLink = multiAudioModel.getMdpTag().getLinkString();

        String marginTop = audioAttributes.getMarginTop();
        String marginBottom = audioAttributes.getMarginBottom();
        String source = compilerContext.getMediaContextUrl() + mdpTagLink;

        htmlBuilder.addLn("<audio class=\"mt-" + marginTop + " mb-" + marginBottom + "\" preload=\"none\" style=\"width: 100%;\" controls=\"controls\">");
        htmlBuilder.addLn(1, "<source type=\"audio/mpeg\" src=\"" + source + "\"/>");
        htmlBuilder.addLn(1, "<a href=\"" + source + "\">" + source + "</a>");
        htmlBuilder.addLn("</audio>");
    }

}
