package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2467Test {
    private val sut = LeetCode2467()

    @Test
    fun case1() {
        assertEquals(
            6,
            sut.mostProfitablePath(
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(3, 4)),
                3,
                intArrayOf(-2, 4, 2, -4, 6)
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            -7280,
            sut.mostProfitablePath(
                arrayOf(intArrayOf(0, 1)),
                1,
                intArrayOf(-7280, 2350)
            )
        )
    }
}