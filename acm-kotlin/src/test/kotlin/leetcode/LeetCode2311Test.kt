package leetcode;

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2311Test {
    private val sut = LeetCode2311()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.longestSubsequence("1001010", 5)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            6,
            sut.longestSubsequence("00101001", 1)
        )
    }
}
