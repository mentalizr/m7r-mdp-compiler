package org.mentalizr.mdpCompiler.inlineElement.inlineParser;

import org.mentalizr.mdpCompiler.inlineElement.link.MDPLinkParser;
import org.mentalizr.mdpCompiler.inlineElement.link.downloadLink.DownloadLinkParser;
import org.mentalizr.mdpCompiler.inlineElement.link.externalLink.ExternalLinkParser;
import org.mentalizr.mdpCompiler.inlineElement.link.infoLink.InfoLinkParser;

import java.util.ArrayList;
import java.util.List;

public class InlineParserMDP {

    private final InlineParser inlineParser3Star;
    private final InlineParser inlineParser2Star;
    private final InlineParser inlineParser1Star;
    private final InlineParser inlineParserBacktick;
    private final MDPLinkParser infoLinkParser;
    private final DownloadLinkParser downloadLinkParser;
    private final ExternalLinkParser externalLinkParser;

    public InlineParserMDP() {

        InlineParserConfig inlineParserConfig3Star = new InlineParserConfig("***", "***", "<em><strong>", "</strong></em>");
        this.inlineParser3Star = new InlineParser(inlineParserConfig3Star, innerToken -> innerToken);

        InlineParserConfig inlineParserConfig2Star = new InlineParserConfig("**", "**", "<strong>", "</strong>");
        this.inlineParser2Star = new InlineParser(inlineParserConfig2Star, innerToken -> innerToken);

        InlineParserConfig inlineParserConfig1Star = new InlineParserConfig("*", "*", "<em>", "</em>");
        this.inlineParser1Star = new InlineParser(inlineParserConfig1Star, innerToken -> innerToken);

        InlineParserConfig inlineParserConfigBackTick = new InlineParserConfig("`", "`", "<code>", "</code>");
        this.inlineParserBacktick = new InlineParser(inlineParserConfigBackTick, innerToken -> innerToken);

        this.infoLinkParser = new InfoLinkParser();

        this.downloadLinkParser = new DownloadLinkParser();

        this.externalLinkParser = new ExternalLinkParser();
    }

    public String parse(String line) {

        String result = line;

        result = this.inlineParser3Star.parse(result);
        result = this.inlineParser2Star.parse(result);
        result = this.inlineParser1Star.parse(result);
        result = this.inlineParserBacktick.parse(result);

        result = this.infoLinkParser.parse(result);
        result = this.downloadLinkParser.parse(result);
        result = this.externalLinkParser.parse(result);

        return result;
    }

    public List<String> parse(List<String> lines) {

        List<String> resultList = new ArrayList<>();

        for (String line : lines) {
            resultList.add(parse(line));
        }

        return resultList;
    }

}
