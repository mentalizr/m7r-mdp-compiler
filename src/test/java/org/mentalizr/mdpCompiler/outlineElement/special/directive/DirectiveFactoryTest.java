package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectiveFactoryTest {

    @Test
    void getInstance() throws MDPSyntaxError {
        DirectiveFactory directiveFactory = new DirectiveFactory();
        OutlineElement outlineElement = directiveFactory.getInstance();

        assertTrue(outlineElement instanceof Directive);
    }

    @Test
    void isResponsible() {
        DocumentIterator documentIterator = DocumentIterator.getInstance(
                "@@name=myName",
                "@@persistent");
        DirectiveFactory directiveFactory = new DirectiveFactory();

        Line firstLine = documentIterator.getNextLine();
        System.out.println(firstLine.getLineIndex() + ": " + firstLine.asString());

        assertTrue(directiveFactory.isResponsible(firstLine));
    }

    @Test
    void isResponsibleNegative() {
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