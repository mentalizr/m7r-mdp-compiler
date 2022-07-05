package org.mentalizr.mdpCompiler.inlineElement.link.downloadLink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DownloadLinkParserTest {

    @Test
    void parse() {

        DownloadLinkParser downloadLinkParser = new DownloadLinkParser();
        String line = "Here some text with @download[a special download link](file.pdf) within.";
        String result = downloadLinkParser.parse(line);

        assertEquals("Here some text with <a href=\"media/file.pdf\" class=\"download-link\" download=\"file.pdf\">a special download link</a> within.", result);
    }

}