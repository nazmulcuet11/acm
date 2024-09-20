package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode214Test {
    private val sut = LeetCode214()

    @Test
    fun testCaseOne() {
        assertEquals(
            "aaacecaaa",
            sut.shortestPalindrome("aacecaaa")
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            "dcbabcd",
            sut.shortestPalindrome("abcd")
        )
    }

    @Test
    fun testCaseThree() {
        assertEquals(
            "",
            sut.shortestPalindrome("")
        )
    }
}