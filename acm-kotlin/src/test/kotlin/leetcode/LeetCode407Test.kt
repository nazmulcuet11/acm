package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode407Test {
    private val sut = LeetCode407()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.trapRainWater(
                arrayOf(
                    intArrayOf(1, 4, 3, 1, 3, 2),
                    intArrayOf(3, 2, 1, 3, 2, 4),
                    intArrayOf(2, 3, 3, 2, 3, 1),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            10,
            sut.trapRainWater(
                arrayOf(
                    intArrayOf(3, 3, 3, 3, 3),
                    intArrayOf(3, 2, 2, 2, 3),
                    intArrayOf(3, 2, 1, 2, 3),
                    intArrayOf(3, 2, 2, 2, 3),
                    intArrayOf(3, 3, 3, 3, 3),
                )
            )
        )
    }
}