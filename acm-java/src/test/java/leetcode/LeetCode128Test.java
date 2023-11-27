package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode128Test {
    LeetCode128 sut = new LeetCode128();

    @Test
    void testCaseOne() {
        assertEquals(4, sut.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    @Test
    void testCaseTwo() {
        assertEquals(9, sut.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    @Test
    void testCaseThree() {
        assertEquals(4, sut.longestConsecutive(new int[]{-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7}));
    }
}