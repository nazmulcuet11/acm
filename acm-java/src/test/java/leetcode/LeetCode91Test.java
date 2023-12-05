package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode91Test {
    private final LeetCode91 sut = new LeetCode91();

    @Test
    void testCaseOne() {
        assertEquals(2, sut.numDecodings("12"));
    }

    @Test
    void testCaseTwo() {
        assertEquals(3, sut.numDecodings("226"));
    }

    @Test
    void testCaseThree() {
        assertEquals(0, sut.numDecodings("06"));
    }
}