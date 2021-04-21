package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;

import java.util.List;

public class HRExtractionFactory extends ExtractionFactory {

    @Override
    public Extraction createInstance(List<Line> lines) {
        return new HRExtraction(lines);
    }

}
