package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2433Test {
    Solution2433 sut = new Solution2433();

    @Test
    void testCaseOne() {
        assertArrayEquals(
            new int[]{5, 7, 2, 3, 2},
            sut.findArray(new int[]{5, 2, 0, 3, 1})
        );
    }

    @Test
    void testCaseTwo() {
        assertArrayEquals(
            new int[]{13},
            sut.findArray(new int[]{13})
        );
    }
}