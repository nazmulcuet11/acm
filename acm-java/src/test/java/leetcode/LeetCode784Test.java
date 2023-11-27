package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode784Test {
    LeetCode784 sut = new LeetCode784();

    @Test
    void testCaseOne() {
        List<String> found = sut.letterCasePermutation("a1b2");
        List<String> expected = Arrays.asList("a1b2","a1B2","A1b2", "A1B2");
        Collections.sort(found);
        Collections.sort(expected);
        assertEquals(found, expected);
    }

    @Test
    void testCaseTwo() {
        List<String> found = sut.letterCasePermutation("3z4");
        List<String> expected = Arrays.asList("3z4","3Z4");
        Collections.sort(found);
        Collections.sort(expected);
        assertEquals(found, expected);
    }
}