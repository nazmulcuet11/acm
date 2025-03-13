package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3356Test {
    private val sut = LeetCode3356()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.minZeroArray(
                intArrayOf(2, 0, 2),
                arrayOf(intArrayOf(0, 2, 1), intArrayOf(0, 2, 1), intArrayOf(1, 1, 3))
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            -1,
            sut.minZeroArray(
                intArrayOf(4, 3, 2, 1),
                arrayOf(intArrayOf(1, 3, 2), intArrayOf(0, 2, 1))
            )
        )
    }
}