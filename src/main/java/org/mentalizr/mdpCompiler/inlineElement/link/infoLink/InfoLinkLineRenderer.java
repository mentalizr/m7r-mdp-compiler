package org.mentalizr.mdpCompiler.inlineElement.link.infoLink;

import org.mentalizr.mdpCompiler.inlineElement.link.LinkLineRendererInterface;
import org.mentalizr.mdpCompiler.inlineElement.link.LinkParserResultForLine;

public class InfoLinkLineRenderer implements LinkLineRendererInterface {

    @Override
    public String process(LinkParserResultForLine linkParserResultForLine) {
        return linkParserResultForLine.getPre()
                + "<a "
                + "href=\"#\" "
                + "id=\"infolink_" + linkParserResultForLine.getId() + "\" "
                + "class=\"infolink\""
                + ">"
                + linkParserResultForLine.getText()
                + "</a>" + linkParserResultForLine.getPost();
    }

}
