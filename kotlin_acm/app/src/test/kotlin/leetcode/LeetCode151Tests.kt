package leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

class LeetCode151Tests {
    val sut = LeetCode151()

    @Test
    fun testCase1() {
        assertEquals("blue is sky the", sut.reverseWords("the sky is blue"))
    }

    @Test
    fun testCase2() {
        assertEquals("world hello", sut.reverseWords("  hello world  "))
    }

    @Test
    fun testCase3() {
        assertEquals("example good a", sut.reverseWords("a good   example"))
    }
}