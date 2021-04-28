package org.mentalizr.mdpCompiler.outlineElement.special.comment;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CommentFactoryTest {

    @Test
    void isResponsible() {
        Comment comment = new Comment();
        Line line = Line.createLine0("// some comment");

        assertTrue(comment.isResponsible(line));
    }

}