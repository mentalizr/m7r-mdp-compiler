package org.mentalizr.mdpCompiler.inlineElement.link;

//import de.net_step.helper.Strings;

import de.arthurpicht.utils.core.strings.Strings;

public abstract class LinkParser {

    // Im Informationstext @info[Was ist eigentlich mit mir los?](1) erhalten Sie einen Überblick

    private final String prefix;
    private static final String MID_DELIMITER = "](";
    private static final String END_DELIMITER = ")";

    private final LinkLineRendererInterface linkLineRendererImpl;

    public LinkParser(String prefix, LinkLineRendererInterface linkLineRendererImpl) {
        this.prefix = prefix;
        this.linkLineRendererImpl = linkLineRendererImpl;
    }

    public String parse(String line) {

        String result = line;

        try {
            //noinspection InfiniteLoopStatement
            while(true) {
                result = parseOnce(result);
            }
        } catch (IllegalArgumentException e) {
            // DIN
        }

        return result;
    }

    private String parseOnce(String line) {

        String[] splitLineArray = Strings.multiSplit(line, this.prefix, MID_DELIMITER, END_DELIMITER);
        LinkParserResultForLine linkParserResultForLine = new LinkParserResultForLine(splitLineArray);

        return linkLineRendererImpl.process(linkParserResultForLine);
    }

}
