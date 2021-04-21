package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.result.Result;

public abstract class OutlineElement {

    protected String prefix;

//    protected List<Line> outlineElementLines;
    protected OutlineElementModel outlineElementModel;

    public OutlineElement(String prefix) {
        this.prefix = prefix;
    }

    protected abstract OutlineElementExtractor getOutlineElementLinesExtractor();

    protected abstract OutlineElementModelBuilder getOutlineElementModelBuilder();

    protected abstract OutlineElementRenderer getOutlineElementRenderer();

    public String getPrefix() {
        return this.prefix;
    }

    public void process(CompilerContext compilerContext, DocumentIterator documentIterator, Result result) throws MDPSyntaxError {

        Extraction extraction = getOutlineElementLinesExtractor().extract(documentIterator);

//        System.out.println("extr. Lines:");
//        for (Line line : this.outlineElementLines) {
//            System.out.println(line.asString());
//        }
//        System.out.println("---");

        this.outlineElementModel = getOutlineElementModelBuilder().getModel(extraction);

        this.getOutlineElementRenderer().render(compilerContext, result);

    }

    public Extraction getExtraction(DocumentIterator documentIterator) {
        return getOutlineElementLinesExtractor().extract(documentIterator);
    }



}
