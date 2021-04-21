package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeadingModelBuilderTest {

    @Test
    void plausi_pos_h1() throws MDPSyntaxError {

        List<Line> listOfLines = Arrays.asList(Line.createLine0("# Eine Überschrift"));
        HeadingModelBuilder headingModelBuilder = new HeadingModelBuilder(1);
        HeadingModel headingModel = headingModelBuilder.getModel(new HeadingExtraction(listOfLines));

        assertEquals("Eine Überschrift", headingModel.getHeading());
    }

    @Test
    void plausi_pos_h2() throws MDPSyntaxError {

        List<Line> listOfLines = Arrays.asList(Line.createLine0("## Eine Überschrift"));
        HeadingModelBuilder headingModelBuilder = new HeadingModelBuilder(2);
        HeadingModel headingModel = headingModelBuilder.getModel(new HeadingExtraction(listOfLines));

        assertEquals("Eine Überschrift", headingModel.getHeading());
    }

    @Test
    void plausi_pos_h5() throws MDPSyntaxError {

        List<Line> listOfLines = Arrays.asList(Line.createLine0("##### Eine Überschrift"));
        HeadingModelBuilder headingModelBuilder = new HeadingModelBuilder(5);
        HeadingModel headingModel = headingModelBuilder.getModel(new HeadingExtraction(listOfLines));

        assertEquals("Eine Überschrift", headingModel.getHeading());
    }



}