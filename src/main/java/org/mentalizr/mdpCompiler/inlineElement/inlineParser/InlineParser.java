package org.mentalizr.mdpCompiler.inlineElement.inlineParser;

public class InlineParser {

    private class NextIndex{

        public int startIndex;
        public int stopIndex;

        public NextIndex(String line) {

            String beginToken = inlineParserConfig.getBeginToken();
            this.startIndex = line.indexOf(beginToken);

            String endToken = inlineParserConfig.getEndToken();
            this.stopIndex = line.indexOf(endToken, startIndex +1);
        }

        public boolean parsingComplete() {
            return (this.startIndex < 0 || this.stopIndex < 0);
        }
    }

    private final InlineParserConfig inlineParserConfig;
    private final TokenContentProcessor tokenContentProcessor;

    public interface TokenContentProcessor {
        String process(String tokenContent);
    }

    public InlineParser(InlineParserConfig inlineParserConfig, TokenContentProcessor tokenContentProcessor) {

        this.inlineParserConfig = inlineParserConfig;
        this.tokenContentProcessor = tokenContentProcessor;
    }

    public String parse(String input) {

        NextIndex nextIndex;
        String result = input;

        while (true) {

            nextIndex = new NextIndex(result);
            if (nextIndex.parsingComplete()) break;

            String pre = result.substring(0, nextIndex.startIndex);
            String beginTokenSubstitute = inlineParserConfig.getBeginTokenSubstitute();
            String tokenContent = result.substring(nextIndex.startIndex + inlineParserConfig.getBeginTokenLength(), nextIndex.stopIndex);
            String tokenContentProcessed = this.tokenContentProcessor.process(tokenContent);
            String endTokenSubstitute = inlineParserConfig.getEndTokenSubstitute();
            String post = result.substring(nextIndex.stopIndex + inlineParserConfig.getEndTokenLength());

            result = pre + beginTokenSubstitute + tokenContentProcessed + endTokenSubstitute + post;
        }

        return result;
    }

}
