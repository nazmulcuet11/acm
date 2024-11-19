package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2461Test {
    private val sut = LeetCode2461()

    @Test
    fun testCase1() {
        assertEquals(
            15,
            sut.maximumSubarraySum(
                intArrayOf(1, 5, 4, 2, 9, 9, 9),
                3
            )
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            0,
            sut.maximumSubarraySum(
                intArrayOf(4, 4, 4),
                3
            )
        )
    }
}