package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

public class ImgTextExtractor extends TextBlockExtractor {

    public ImgTextExtractor() {
        super(new ImgTextExtractionFactory());
    }

}
