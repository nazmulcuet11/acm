package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class LeetCode22Test {
    private final LeetCode22 sut = new LeetCode22();

    @Test
    void testCaseOne() {
        var expected = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        assertIterableEquals(expected, sut.generateParenthesis(3));
    }

    @Test
    void testCaseTwo() {
        var expected = List.of("()");
        assertIterableEquals(expected, sut.generateParenthesis(1));
    }
}