package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.List;

public abstract class OutlineElement {

    protected String prefix;

    protected List<Line> outlineElementLines;
    protected OutlineElementModel outlineElementModel;

    public OutlineElement(String prefix) {
        this.prefix = prefix;
    }

    protected abstract OutlineElementLinesExtractor getOutlineElementLinesExtractor();

    protected abstract OutlineElementModelBuilder getOutlineElementModelBuilder();

    protected abstract OutlineElementRenderer getOutlineElementRenderer();

    public String getPrefix() {
        return this.prefix;
    }

    public void process(CompilerContext compilerContext, DocumentIterator documentIterator, Result result) throws MDPSyntaxError {

        this.outlineElementLines = getOutlineElementLinesExtractor().extract(documentIterator);

//        System.out.println("extr. Lines:");
//        for (Line line : this.outlineElementLines) {
//            System.out.println(line.asString());
//        }
//        System.out.println("---");

        this.outlineElementModel = getOutlineElementModelBuilder().getModel();

        this.getOutlineElementRenderer().render(compilerContext, result);

    }

}
