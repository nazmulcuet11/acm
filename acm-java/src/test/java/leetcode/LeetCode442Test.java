package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode442Test {
    LeetCode442 sut = new LeetCode442();
    @Test
    void testCaseOne() {
        assertIterableEquals(List.of(2, 3), sut.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    @Test
    void testCaseTwo() {
        assertIterableEquals(List.of(1), sut.findDuplicates(new int[]{1, 1, 2}));
    }

    @Test
    void testCaseThree() {
        assertIterableEquals(List.of(), sut.findDuplicates(new int[]{1}));
    }
}