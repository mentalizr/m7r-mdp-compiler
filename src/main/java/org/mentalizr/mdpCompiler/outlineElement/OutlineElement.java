package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.util.Objects;

public abstract class OutlineElement {

    protected String prefix;

    public OutlineElement(String prefix) {
        this.prefix = prefix;
    }

    protected abstract OutlineElementExtractor getOutlineElementLinesExtractor();

    protected abstract OutlineElementModelBuilder getOutlineElementModelBuilder() throws MDPSyntaxError;

    protected abstract OutlineElementRenderer getOutlineElementRenderer();

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isResponsible(Line line) {
        return line.asString().startsWith(this.prefix);
    }

    public Extraction getExtraction(DocumentIterator documentIterator) {
        return getOutlineElementLinesExtractor().extract(documentIterator);
    }

    public OutlineElementModel getModel(Extraction extraction) throws MDPSyntaxError {
        return getOutlineElementModelBuilder().getModel(extraction);
    }

    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {
        getOutlineElementRenderer().render(outlineElementModel, compilerContext, htmlBuilder);
    }

//    public void process(CompilerContext compilerContext, DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
//        Extraction extraction = getOutlineElementLinesExtractor().extract(documentIterator);
//        OutlineElementModel outlineElementModel = getOutlineElementModelBuilder().getModel(extraction);
//        this.getOutlineElementRenderer().render(outlineElementModel, compilerContext, result);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutlineElement that = (OutlineElement) o;
        return prefix.equals(that.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix);
    }

}
