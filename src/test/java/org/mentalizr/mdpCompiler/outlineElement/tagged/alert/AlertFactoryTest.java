package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlertFactoryTest {

    @Test
    void isResponsible() {
        AlertFactory alertFactory = new AlertFactory();
        Line line = Line.createLine0("@alert[type=\"info\" headersize=\"3\"]");

        Assertions.assertTrue(alertFactory.isResponsible(line));
    }
}