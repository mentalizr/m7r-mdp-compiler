package org.mentalizr.mdpCompiler.mdpTag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MDPTagSimpleUtilTest {

    @Test
    void pos_1() {
        assertTrue(MDPTagUtil.isMDPTag("@myTag[myAttributeString]"));
    }

    @Test
    void pos_2() {
        assertTrue(MDPTagUtil.isMDPTag("@Tag[]"));
    }

    @Test
    void pos_3() {
        assertTrue(MDPTagUtil.isMDPTag("@Tag[asdf]noch was"));
    }

    @Test
    void neg_1() {
        assertFalse(MDPTagUtil.isMDPTag("Test"));
    }

    @Test
    void neg_2() {
        assertFalse(MDPTagUtil.isMDPTag("@Am Anfang steht das Zeichen."));
    }





}