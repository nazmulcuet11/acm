package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3413Test {
    private val sut = LeetCode3413()

    @Test
    fun case1() {
        assertEquals(
            10,
            sut.maximumCoins(
                arrayOf(intArrayOf(8, 10, 1), intArrayOf(1, 3, 2), intArrayOf(5, 6, 4)),
                4
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            6,
            sut.maximumCoins(
                arrayOf(intArrayOf(1, 10, 3)),
                2
            )
        )
    }
}