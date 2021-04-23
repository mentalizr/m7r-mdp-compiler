package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CommentFactoryTest {

    @Test
    void getInstance() throws MDPSyntaxError {
        CommentFactory commentFactory = new CommentFactory();
        OutlineElement outlineElement = commentFactory.getInstance();

        assertTrue(outlineElement instanceof Comment);
    }

    @Test
    void isResponsible() {
        CommentFactory commentFactory = new CommentFactory();
        Line line = Line.createLine0("// some comment");

        assertTrue(commentFactory.isResponsible(line));
    }

}