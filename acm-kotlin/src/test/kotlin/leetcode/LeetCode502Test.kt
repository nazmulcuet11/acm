package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode502Test {
    val sut = LeetCode502()

    @Test
    fun testCaseOne() {
        assertEquals(
            4,
            sut.findMaximizedCapital(
                2,
                0,
                intArrayOf(1, 2, 3),
                intArrayOf(0, 1, 1)
            )
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            6,
            sut.findMaximizedCapital(
                3,
                0,
                intArrayOf(1, 2, 3),
                intArrayOf(0, 1, 2)
            )
        )
    }
}