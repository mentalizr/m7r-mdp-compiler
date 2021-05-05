package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import java.util.List;

public class AlertExtraction extends Extraction {

    public AlertExtraction(List<Line> lines) {
        super(lines);
    }

    public AlertExtraction(Document document) {
        super(document);
    }
}
