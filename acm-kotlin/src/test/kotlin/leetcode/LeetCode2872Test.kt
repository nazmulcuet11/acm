package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2872Test {
    private val sut = LeetCode2872()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.maxKDivisibleComponents(
                5,
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 4),
                ),
                intArrayOf(1, 8, 1, 4, 40),
                6
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            3,
            sut.maxKDivisibleComponents(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 5),
                    intArrayOf(2, 6),
                ),
                intArrayOf(3, 0, 6, 1, 5, 2, 1),
                3
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            1,
            sut.maxKDivisibleComponents(
                1,
                arrayOf(),
                intArrayOf(0),
                1
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            1,
            sut.maxKDivisibleComponents(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 5),
                    intArrayOf(2, 6),
                ),
                intArrayOf(1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000),
                7
            )
        )
    }
}