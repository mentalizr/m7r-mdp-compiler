package org.mentalizr.mdpCompiler.inlineElement.link;

public class TestLinkLineRenderer implements LinkLineRendererInterface {

    @Override
    public String process(LinkParserResultForLine linkParserResultForLine) {

        return linkParserResultForLine.getPre() + "[*]"
                + linkParserResultForLine.getText() + "[*]"
                + linkParserResultForLine.getId() + "[*]"
                + linkParserResultForLine.getPost();
    }

}
