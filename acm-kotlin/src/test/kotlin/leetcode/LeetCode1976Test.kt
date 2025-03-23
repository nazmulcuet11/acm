package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1976Test {
    private val sut = LeetCode1976()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.countPaths(
                7,
                arrayOf(
                    intArrayOf(0, 6, 7),
                    intArrayOf(0, 1, 2),
                    intArrayOf(1, 2, 3),
                    intArrayOf(1, 3, 3),
                    intArrayOf(6, 3, 3),
                    intArrayOf(3, 5, 1),
                    intArrayOf(6, 5, 1),
                    intArrayOf(2, 5, 1),
                    intArrayOf(0, 4, 5),
                    intArrayOf(4, 6, 2)
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.countPaths(
                2,
                arrayOf(intArrayOf(1, 0, 10))
            )
        )
    }
}