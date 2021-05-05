package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.document.Line;

import java.util.List;

public abstract class ExtractionFactory {

    public abstract Extraction createInstance(List<Line> lines);

}
