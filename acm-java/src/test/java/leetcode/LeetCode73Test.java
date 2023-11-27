package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode73Test {
    LeetCode73 sut = new LeetCode73();

    @Test
    void testCaseOne() {
        var input = new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
        };
        var expected = new int[][]{
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1},
        };
        sut.setZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testCaseTwo() {
        var input = new int[][]{
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        var expected = new int[][]{
            {0, 0, 0, 0},
            {0, 4, 5, 0},
            {0, 3, 1, 0}
        };
        sut.setZeroes(input);
        assertArrayEquals(expected, input);
    }
}