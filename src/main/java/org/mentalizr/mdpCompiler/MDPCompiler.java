package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.DocumentSanityChecker;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRegistry;
import org.mentalizr.mdpCompiler.outlineElement.special.directive.Directive;
import org.mentalizr.mdpCompiler.outlineElement.special.directive.DirectiveModel;
import org.mentalizr.mdpCompiler.result.Result;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MDPCompiler {

    public enum Mode {MD, MDP_COMPLETE, MD_AND_MDP_NESTABLE}

    public static void compile(File input, File output) throws IOException, MDPSyntaxError {
        Result result = MDPCompiler.compile(new Document(input));
        result.write(output);
    }

    public static List<String> compile(File input) throws IOException, MDPSyntaxError {
        Result result = MDPCompiler.compile(new Document(input));
        return result.getResultLines();
    }

    public static Result compile(Document document) throws MDPSyntaxError {
        Dom dom = createDom(document);
        return render(dom);
    }

    public static Dom createDom(Document document) throws MDPSyntaxError {

        DocumentSanityChecker.check(document);

        DocumentIterator documentIterator = document.getDocumentIterator();
        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry();
        Dom dom = new Dom();

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

    public static Result render(Dom dom) {
        Result result = new Result();
        CompilerContext compilerContext = new CompilerContext(true, 0);
        List<OutlineElementModel> models = dom.getOutlineElementModels();

        for (OutlineElementModel model : models) {
            OutlineElement outlineElement = model.getOutlineElement();
            outlineElement.render(model, compilerContext, result);
        }
        return result;
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

    public static void renderSubdocument(List<OutlineElementModel> outlineElementModelList, Result result, CompilerContext compilerContext) {
        for (OutlineElementModel outlineElementModel : outlineElementModelList) {
            outlineElementModel.getOutlineElement().render(
                    outlineElementModel,
                    new CompilerContext(false, compilerContext.getIndentLevel() + 1),
                    result
            );
        }
    }

}
