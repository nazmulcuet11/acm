package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2563Test {
    private val sut = LeetCode2563()

    @Test
    fun testCase1() {
        assertEquals(
            6,
            sut.countFairPairs(
                intArrayOf(0, 1, 7, 4, 4, 5),
                3,
                6
            )
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            1,
            sut.countFairPairs(
                intArrayOf(1, 7, 9, 2, 5),
                11,
                11
            )
        )
    }
}