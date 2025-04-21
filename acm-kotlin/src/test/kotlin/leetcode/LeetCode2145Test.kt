package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2145Test {
    private val sut = LeetCode2145()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.numberOfArrays(
                intArrayOf(1, -3, 4),
                1,
                6
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.numberOfArrays(
                intArrayOf(3, -4, 5, 1, -2),
                -4,
                5
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            0,
            sut.numberOfArrays(
                intArrayOf(4, -7, 2),
                3,
                6
            )
        )
    }
}