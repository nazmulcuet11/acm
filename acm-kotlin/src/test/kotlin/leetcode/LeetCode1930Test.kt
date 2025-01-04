package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1930Test {
    private val sut = LeetCode1930()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.countPalindromicSubsequence("aabca")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.countPalindromicSubsequence("adc")
        )
    }

    @Test
    fun case3() {
        assertEquals(
            4,
            sut.countPalindromicSubsequence("bbcbaba")
        )
    }
}