package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import java.util.List;

public class CollapsableExtraction extends Extraction {

    public CollapsableExtraction(List<Line> lines) {
        super(lines);
    }

    public CollapsableExtraction(Document document) {
        super(document);
    }
}
