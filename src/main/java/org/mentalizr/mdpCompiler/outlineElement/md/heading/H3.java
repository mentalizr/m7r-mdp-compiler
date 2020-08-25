package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.result.Result;

public class H3 extends Heading {

    public static final String PREFIX = "### ";

    public H3(DocumentIterator documentIterator, Result result) {
        super(PREFIX, documentIterator, result);
    }

}
