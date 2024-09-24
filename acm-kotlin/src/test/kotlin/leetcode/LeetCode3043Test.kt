package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3043Test {
    private val sut = LeetCode3043()

    @Test
    fun testCaseOne() {
        assertEquals(
            3,
            sut.longestCommonPrefix(intArrayOf(1, 10, 100), intArrayOf(1000))
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            0,
            sut.longestCommonPrefix(intArrayOf(1, 2, 3), intArrayOf(4, 4, 4))
        )
    }

    @Test
    fun testCaseThree() {
        assertEquals(
            1,
            sut.longestCommonPrefix(intArrayOf(10), intArrayOf(17, 11))
        )
    }
}