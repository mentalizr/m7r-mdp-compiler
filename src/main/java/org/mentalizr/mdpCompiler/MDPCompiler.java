package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.DocumentSanityChecker;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRegistry;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompiler.result.ResultWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MDPCompiler {

    public enum Mode {MD, MDP_COMPLETE, MD_AND_MDP_NESTABLE}

    public static void compile(File input, File output) throws IOException, MDPSyntaxError {
        ResultWriter resultWriter = new ResultWriter();
        MDPCompiler.compileMdpDocument(new Document(input), resultWriter);
        resultWriter.write(output);
    }

    public static List<String> compile(File input) throws IOException, MDPSyntaxError {
        ResultWriter resultWriter = new ResultWriter();
        MDPCompiler.compileMdpDocument(new Document(input), resultWriter);
        return resultWriter.getResultLines();
    }

    /**
     * Compiles a document applying all elements, including markdown elements and mdp elements.
     *
     * @param document
     * @param result
     * @throws MDPSyntaxError
     */
    public static void compileMdpDocument(Document document, Result result) throws MDPSyntaxError {
        compile(document, result, Mode.MDP_COMPLETE, new CompilerContext(true, 0));
    }

    public static void compileSubdocument(Document document, Result result, CompilerContext compilerContext) throws MDPSyntaxError {
        compile(document, result, Mode.MD_AND_MDP_NESTABLE, new CompilerContext(false, compilerContext.getIndentLevel() + 1));
    }

    private static void compile(Document document, Result result, Mode mode, CompilerContext compilerContext) throws MDPSyntaxError {

        DocumentSanityChecker.check(document);

        DocumentIterator documentIterator = document.getDocumentIterator();
        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry();

        while (documentIterator.hasNextLine()) {

            Line line = documentIterator.getNextLine();

            if (line.asString().isBlank()) continue;

            OutlineElement outlineElement;
            outlineElement = outlineElementRegistry.getMatchingElement(line, mode);
            outlineElement.process(compilerContext, documentIterator, result);

        }
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

    public static void renderSubdocument(List<OutlineElementModel> outlineElementModelList, Result result, CompilerContext compilerContext) throws MDPSyntaxError {

        for (OutlineElementModel outlineElementModel : outlineElementModelList) {
            outlineElementModel.getOutlineElement().render(outlineElementModel, new CompilerContext(false, compilerContext.getIndentLevel() + 1), result);
        }
    }


//    public static void buildAbstractSyntaxTree(Document document) throws MDPSyntaxError {
//        CompilerContext compilerContext = new CompilerContext(true, 0);
//
//        DocumentSanityChecker.check(document);
//
//        DocumentIterator documentIterator = document.getDocumentIterator();
//        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry();
//
//        while (documentIterator.hasNextLine()) {
//
//            Line line = documentIterator.getNextLine();
//
//            if (line.asString().isBlank()) continue;
//
//            OutlineElement outlineElement = outlineElementRegistry.getMatchingElement(line, Mode.MDP_COMPLETE);
//            Extraction extraction = outlineElement.getExtraction(documentIterator);
//
//            outlineElement.process(compilerContext);
//
//        }
//
//    }

}
