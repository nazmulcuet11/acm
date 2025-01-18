package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1368Test {
    private val sut = LeetCode1368()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.minCost(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(4, 3),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.minCost(
                arrayOf(
                    intArrayOf(1, 1, 3),
                    intArrayOf(3, 2, 2),
                    intArrayOf(1, 1, 4),
                )
            )
        )
    }
}