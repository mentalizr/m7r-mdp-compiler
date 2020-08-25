package org.mentalizr.mdpCompiler.inlineElement.link.externalLink;

import org.mentalizr.mdpCompiler.inlineElement.link.LinkLineRendererInterface;
import org.mentalizr.mdpCompiler.inlineElement.link.LinkParserResultForLine;

public class ExternalLinkLineRenderer implements LinkLineRendererInterface {

    @Override
    public String process(LinkParserResultForLine linkParserResultForLine) {
        return linkParserResultForLine.getPre()
                + "<a "
                + "href=\"" + linkParserResultForLine.getId() + "\" "
                + "class=\"external-link\" "
                + "target=\"_blank\" "
                + "rel=\"noreferrer noopener\""
                + ">"
                + linkParserResultForLine.getText()
                + "</a>"
                + linkParserResultForLine.getPost();
    }

}
