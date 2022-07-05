package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.audio.Audio;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBench;
import org.mentalizr.mdpCompilerTestResrc.OutlineElementTestBenchExecutor;

import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")
class ImgCenterTest {

    @Test
    void plausibilityTest() throws MDPSyntaxError {

        OutlineElementTestBenchExecutor outlineElementTestBenchExecutor
                = new OutlineElementTestBenchExecutor(new ImgCenter())
                .withMDPLines(
                        "@img-center[alt=\"Ein alternativer Text\"](picture.jpg)",
                        "Something completely different ..."
                )
                .withExpectedLines(
                        "<img src=\"media/picture.jpg\" class=\"mx-auto d-block mb-0 mt-0\" alt=\"Ein alternativer Text\">"
                )
                .withExpectedDocumentIteratorIndex(1)
                .withMediaResources("picture.jpg");

        OutlineElementTestBench.execute(outlineElementTestBenchExecutor);
    }

}