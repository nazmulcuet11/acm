package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode402Test {
    private final LeetCode402 sut = new LeetCode402();

    @Test
    void testCaseOne() {
        assertEquals("1219", sut.removeKdigits("1432219", 3));
    }

    @Test
    void testCaseTwo() {
        assertEquals("200", sut.removeKdigits("10200", 1));
    }

    @Test
    void testCaseThree() {
        assertEquals("0", sut.removeKdigits("10", 1));
    }
}