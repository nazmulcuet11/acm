package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode71Test {
    private final LeetCode71 sut = new LeetCode71();

    @Test
    void testCaseOne() {
        assertEquals("/home", sut.simplifyPath("/home/"));
    }

    @Test
    void testCaseTwo() {
        assertEquals("/", sut.simplifyPath("/../"));
    }

    @Test
    void testCaseThree() {
        assertEquals("/home/foo", sut.simplifyPath("/home//foo/"));
    }

    @Test
    void testCaseFour() {
        assertEquals("/c", sut.simplifyPath("/a/./b/../../c/"));
    }
}