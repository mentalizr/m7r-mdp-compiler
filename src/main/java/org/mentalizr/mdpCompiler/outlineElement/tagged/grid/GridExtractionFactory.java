package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.CardExtraction;

import java.util.List;

public class GridExtractionFactory extends ExtractionFactory {

    @Override
    public Extraction createInstance(List<Line> lines) {
        return new GridExtraction(lines);
    }

}
