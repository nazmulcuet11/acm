package leetcode

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class LeetCode2825Test {
    private val sut = LeetCode2825()

    @Test
    fun case1() {
        assertTrue(sut.canMakeSubsequence("abc", "ad"))
    }

    @Test
    fun case2() {
        assertTrue(sut.canMakeSubsequence("zc", "ad"))
    }

    @Test
    fun case3() {
        assertFalse(sut.canMakeSubsequence("ab", "d"))
    }
}
