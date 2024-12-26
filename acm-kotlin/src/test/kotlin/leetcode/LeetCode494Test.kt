package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode494Test {
    private val sut = LeetCode494()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.findTargetSumWays(
                intArrayOf(1, 1, 1, 1, 1),
                3
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.findTargetSumWays(
                intArrayOf(1),
                1
            )
        )
    }
}