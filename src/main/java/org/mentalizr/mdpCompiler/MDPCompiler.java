package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.DocumentSanityChecker;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRegistry;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompiler.result.ResultWriter;

import java.io.File;
import java.io.IOException;

public class MDPCompiler {

    public enum Mode {MD, MDP_COMPLETE, MD_AND_MDP_NESTABLE}

    public static void compile(File input, File output) throws IOException, MDPSyntaxError {
        ResultWriter resultWriter = new ResultWriter();
        MDPCompiler.compileMdpDocument(new Document(input), resultWriter);
        resultWriter.write(output);
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
        OutlineElementRegistry outlineElementRegistry = new OutlineElementRegistry(result, documentIterator);

        while (documentIterator.hasNextLine()) {

            Line line = documentIterator.getNextLine();

            if (line.asString().isBlank()) continue;

            OutlineElement outlineElement;
            outlineElement = outlineElementRegistry.getMatchingElement(line, mode);
            outlineElement.process(compilerContext);

        }
    }

}
