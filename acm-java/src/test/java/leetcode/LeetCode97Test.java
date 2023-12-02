package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode97Test {
    private final LeetCode97 sut = new LeetCode97();

    @Test
    void testCaseOne() {
        assertTrue(sut.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    void testCaseTwo() {
        assertFalse(sut.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    void testCaseThree() {
        assertTrue(sut.isInterleave("", "", ""));
    }
}