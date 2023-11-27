package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode287Test {
    LeetCode287 sut = new LeetCode287();

    @Test
    void testCaseOne() {
        assertEquals(2, sut.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    void testCaseTwo() {
        assertEquals(3, sut.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    @Test
    void testCaseThree() {
        assertEquals(2, sut.findDuplicate(new int[]{2, 2, 2, 2, 2}));
    }
}