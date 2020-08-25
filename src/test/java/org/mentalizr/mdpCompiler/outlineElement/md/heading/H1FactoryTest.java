package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class H1FactoryTest {

    @Test
    void isResponsible() {

        H1Factory h1Factory = new H1Factory();

        Assertions.assertTrue(h1Factory.isResponsible(Line.createLine0("# Eine Überschrift")));

        Assertions.assertFalse(h1Factory.isResponsible(Line.createLine0(" # Eine Überschrift")));

        Assertions.assertFalse(h1Factory.isResponsible(Line.createLine0("## A H2 header")));
        Assertions.assertFalse(h1Factory.isResponsible(Line.createLine0("Something completely different.")));
    }

}