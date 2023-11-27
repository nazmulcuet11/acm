package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode54Test {
    LeetCode54 sut = new LeetCode54();

    @Test
    void testCaseOne() {
        var input = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };

        var expected = new ArrayList<>(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5));
        assertIterableEquals(expected, sut.spiralOrder(input));
    }

    @Test
    void testCaseTwo() {
        var input = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
        };

        var expected = new ArrayList<>(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
        assertIterableEquals(expected, sut.spiralOrder(input));
    }
}