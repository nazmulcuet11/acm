package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2419Test {
    private val sut = LeetCode2419()

    @Test
    fun testCaseOne() {
        assertEquals(
            2,
            sut.longestSubarray(intArrayOf(1,2,3,3,2,2))
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            1,
            sut.longestSubarray(intArrayOf(1,2,3,4))
        )
    }
}