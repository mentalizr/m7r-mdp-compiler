package org.mentalizr.mdpCompiler.inlineElement.link.downloadLink;

import org.mentalizr.mdpCompiler.inlineElement.link.LinkLineRendererInterface;
import org.mentalizr.mdpCompiler.inlineElement.link.LinkParserResultForLine;

public class DownloadLinkLineRenderer implements LinkLineRendererInterface {

    @Override
    public String process(LinkParserResultForLine linkParserResultForLine) {
        return linkParserResultForLine.getPre()
                + "<a "
                + "href=\"media/" + linkParserResultForLine.getId() + "\" "
                + "class=\"download-link\" "
                + "download=\"" + linkParserResultForLine.getId() + "\""
                + ">"
                + linkParserResultForLine.getText()
                + "</a>" + linkParserResultForLine.getPost();
    }

}
