package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode7Test {
    LeetCode7 sut = new LeetCode7();

    @Test
    void testCaseOne() {
        assertEquals(321, sut.reverse(123));
    }

    @Test
    void testCaseTwo() {
        assertEquals(-321, sut.reverse(-123));
    }

    @Test
    void testCaseThree() {
        assertEquals(21, sut.reverse(120));
    }

    @Test
    void testCaseFour() {
        assertEquals(0, sut.reverse(Integer.MAX_VALUE));
    }

    @Test
    void testCaseFive() {
        assertEquals(0, sut.reverse(Integer.MIN_VALUE));
    }
}