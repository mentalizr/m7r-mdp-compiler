package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.result.Result;
import org.mentalizr.mdpCompilerTestResrc.ResultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentFactoryTest {

    @Test
    void getInstance() throws MDPSyntaxError {

        DocumentIterator documentIterator = DocumentIterator.getInstance("// Some comment");
        Result result = new ResultTest();
        CommentFactory commentFactory = new CommentFactory();
        OutlineElement outlineElement = commentFactory.getInstance(documentIterator, result);

        assertTrue(outlineElement instanceof Comment);
    }

    @Test
    void isResponsible() {

        CommentFactory commentFactory = new CommentFactory();
        Line line = Line.createLine0("// some comment");

        assertTrue(commentFactory.isResponsible(line));
    }

}