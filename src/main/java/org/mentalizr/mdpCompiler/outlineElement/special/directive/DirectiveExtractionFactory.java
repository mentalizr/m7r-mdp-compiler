package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;
import org.mentalizr.mdpCompiler.outlineElement.special.comment.CommentExtraction;

import java.util.List;

public class DirectiveExtractionFactory extends ExtractionFactory {

    @Override
    public Extraction createInstance(List<Line> lines) {
        return new DirectiveExtraction(lines);
    }

}
