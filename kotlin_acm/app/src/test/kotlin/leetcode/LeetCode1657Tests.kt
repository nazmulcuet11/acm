package leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

class LeetCode1657Tests {
    val sut = LeetCode1657()

    @Test
    fun testCase1() {
        assertEquals(true, sut.closeStrings("abc", "bca"))
    }

    @Test
    fun testCase2() {
        assertEquals(false, sut.closeStrings("a", "aa"))
    }

    @Test
    fun testCase3() {
        assertEquals(true, sut.closeStrings("cabbba", "abbccc"))
    }
}