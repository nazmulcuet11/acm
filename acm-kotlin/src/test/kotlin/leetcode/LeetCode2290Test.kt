package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2290Test {
    private val sut = LeetCode2290()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.minimumObstacles(
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.minimumObstacles(
                arrayOf(
                    intArrayOf(0, 1, 0, 0, 0),
                    intArrayOf(0, 1, 0, 1, 0),
                    intArrayOf(0, 0, 0, 1, 0),
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            5,
            sut.minimumObstacles(
                arrayOf(
                    intArrayOf(0, 0, 1, 1, 1, 1, 0, 0, 0, 1),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 0, 1, 1),
                    intArrayOf(1, 1, 0, 1, 1, 1, 1, 0, 1, 0),
                    intArrayOf(0, 0, 1, 1, 1, 1, 0, 0, 1, 1),
                    intArrayOf(1, 0, 1, 0, 0, 0, 1, 1, 1, 0),
                )
            )
        )
    }
}