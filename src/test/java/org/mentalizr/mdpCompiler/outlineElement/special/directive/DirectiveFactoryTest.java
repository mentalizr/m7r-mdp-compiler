package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectiveFactoryTest {

    @Test
    void getInstance() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance("@@name=myName", "@@persistent");
        Result result = new ResultTest();
        DirectiveFactory directiveFactory = new DirectiveFactory();
        OutlineElement outlineElement = directiveFactory.getInstance(documentIterator, result);

        assertTrue(outlineElement instanceof Directive);
    }

    @Test
    void isResponsible() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@@name=myName",
                "@@persistent");
        DirectiveFactory directiveFactory = new DirectiveFactory();

        Line firstLine = documentIterator.getNextLine();
        System.out.println(firstLine.getLineIndex() + ": " + firstLine.asString());

        assertTrue(directiveFactory.isResponsible(firstLine));
    }

    @Test
    void isResponsibleNegative() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "",
                "@@name=myName",
                "@@persistent");
        DirectiveFactory directiveFactory = new DirectiveFactory();

        Line firstLine = documentIterator.getNextLine();
        System.out.println(firstLine.getLineIndex() + ": " + firstLine.asString());

        assertFalse(directiveFactory.isResponsible(firstLine));
    }

}