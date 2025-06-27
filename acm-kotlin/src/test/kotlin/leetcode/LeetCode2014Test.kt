package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2014Test {
    private val sut = LeetCode2014()

    @Test
    fun case1() {
        assertEquals(
            "let",
            sut.longestSubsequenceRepeatedK("letsleetcode", 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "b",
            sut.longestSubsequenceRepeatedK("bb", 2)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            "",
            sut.longestSubsequenceRepeatedK("ab", 2)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            "bbbb",
            sut.longestSubsequenceRepeatedK("bbabbabbbbabaababab", 3)
        )
    }
}