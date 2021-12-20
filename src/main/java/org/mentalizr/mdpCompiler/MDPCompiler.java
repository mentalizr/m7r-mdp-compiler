package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.DocumentSanityChecker;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRegistry;
import org.mentalizr.mdpCompiler.outlineElement.special.directive.DirectiveModel;
import org.mentalizr.mdpCompiler.result.Html;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MDPCompiler {

    public enum Mode {MDP_COMPLETE, MD_AND_MDP_NESTABLE}

    public static void compile(File input, File output) throws IOException, MDPSyntaxError {
        Html html = MDPCompiler.compile(new Document(input));
        html.write(output);
    }

    public static List<String> compile(File input) throws IOException, MDPSyntaxError {
        Html html = MDPCompiler.compile(new Document(input));
        return html.getLines();
    }

    public static Html compile(Document document) throws MDPSyntaxError {
        Dom dom = createDom(document);
        return render(dom);
    }

    public static Dom createDom(File mdpFile) throws IOException, MDPSyntaxError {
        return createDom(new Document(mdpFile));
    }

    public static Set<String> getReferencedMediaResources(File mdpFile) throws IOException, MDPSyntaxError {
        Dom dom = createDom(new Document(mdpFile));
        return dom.getReferencedMediaResources();
    }

    public static Dom createDom(Document document) throws MDPSyntaxError {

        DocumentSanityChecker.check(document);

        DocumentIterator documentIterator = document.getDocumentIterator();
        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry();
        Dom dom = new DomImpl();

        while (documentIterator.hasNextLine()) {

            Line line = documentIterator.getNextLine();
            if (line.asString().isBlank()) continue;

            OutlineElement outlineElement = outlineElementRegistry.getMatchingElement(line, Mode.MDP_COMPLETE);
            Extraction extraction = outlineElement.getExtraction(documentIterator);
            OutlineElementModel outlineElementModel = outlineElement.getModel(extraction);
            dom.addOutlineElementModel(outlineElementModel);
        }

        validateDom(dom);

        return dom;
    }

    private static void validateDom(Dom dom) throws MDPSyntaxError {
        if (dom.getOutlineElementModels().isEmpty())
            throw new MDPSyntaxError(new Line("", 0), "MDP document is undefined.");

        OutlineElementModel outlineElementModel = dom.getOutlineElementModels().get(0);
        String errorMessage = "@@name directive missing.";

        if (!(outlineElementModel instanceof DirectiveModel)) {
            Line line = new Line("", 0);
            throw new MDPSyntaxError(line, errorMessage);
        }

        DirectiveModel directiveModel = (DirectiveModel) outlineElementModel;
        for (String directive : directiveModel.getDirectives()) {
            if (directive.startsWith("@@name=")) return;
        }
        throw new MDPSyntaxError(new Line("", 0), errorMessage);
    }

    public static Html render(Dom dom) {
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        CompilerContext compilerContext = new CompilerContext(true, 0);
        List<OutlineElementModel> models = dom.getOutlineElementModels();

        for (OutlineElementModel model : models) {
            OutlineElement outlineElement = model.getOutlineElement();
            outlineElement.render(model, compilerContext, htmlBuilder);
        }

        return htmlBuilder.getHtml();
    }

    public static List<OutlineElementModel> getModelsForSubdocument(Document document) throws MDPSyntaxError {

        DocumentIterator documentIterator = document.getDocumentIterator();
        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry();

        List<OutlineElementModel> modelList = new ArrayList<>();

        while (documentIterator.hasNextLine()) {

            Line line = documentIterator.getNextLine();

            if (line.asString().isBlank()) continue;

            OutlineElement outlineElement = outlineElementRegistry.getMatchingElement(line, Mode.MD_AND_MDP_NESTABLE);

            Extraction extraction = outlineElement.getExtraction(documentIterator);
            OutlineElementModel outlineElementModel = outlineElement.getModel(extraction);
            modelList.add(outlineElementModel);
        }

        return modelList;
    }

    public static void renderSubdocument(List<OutlineElementModel> outlineElementModelList, HtmlBuilder htmlBuilder, CompilerContext compilerContext) {
        for (OutlineElementModel outlineElementModel : outlineElementModelList) {
            outlineElementModel.getOutlineElement().render(
                    outlineElementModel,
                    new CompilerContext(false, compilerContext.getIndentLevel() + 1),
                    htmlBuilder
            );
        }
    }

}
