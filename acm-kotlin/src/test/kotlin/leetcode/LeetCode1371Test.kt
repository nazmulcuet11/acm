package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1371Test {
    private val sut = LeetCode1371()

    @Test
    fun testCaseOne() {
        assertEquals(
            13,
            sut.findTheLongestSubstring("eleetminicoworoep")
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            5,
            sut.findTheLongestSubstring("leetcodeisgreat")
        )
    }

    @Test
    fun testCaseThree() {
        assertEquals(
            6,
            sut.findTheLongestSubstring("bcbcbc")
        )
    }
}