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

    @Test
    fun case3() {
        assertEquals(
            4,
            sut.minZeroArray(
                intArrayOf(2, 10),
                arrayOf(
                    intArrayOf(1, 1, 5),
                    intArrayOf(0, 1, 2),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 5),
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 1, 4),
                    intArrayOf(1, 1, 3),
                    intArrayOf(1, 1, 3),
                    intArrayOf(0, 0, 5),
                    intArrayOf(0, 1, 2),
                    intArrayOf(1, 1, 3),
                    intArrayOf(1, 1, 4),
                    intArrayOf(1, 1, 4),
                    intArrayOf(0, 1, 5),
                    intArrayOf(1, 1, 1)
                )
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            6,
            sut.minZeroArray(
                intArrayOf(1, 0, 6),
                arrayOf(
                    intArrayOf(1, 2, 1),
                    intArrayOf(0, 0, 4),
                    intArrayOf(1, 1, 5),
                    intArrayOf(0, 0, 5),
                    intArrayOf(1, 2, 4),
                    intArrayOf(0, 2, 2),
                    intArrayOf(2, 2, 4),
                    intArrayOf(1, 2, 2),
                    intArrayOf(1, 2, 4),
                    intArrayOf(0, 1, 3)
                )
            )
        )
    }
}