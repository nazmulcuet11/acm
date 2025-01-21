package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2017Test {
    private val sut = LeetCode2017()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.gridGame(
                arrayOf(
                    intArrayOf(2, 5, 4),
                    intArrayOf(1, 5, 1)
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.gridGame(
                arrayOf(
                    intArrayOf(3, 3, 1),
                    intArrayOf(8, 5, 2)
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            7,
            sut.gridGame(
                arrayOf(
                    intArrayOf(1, 3, 1, 15),
                    intArrayOf(1, 3, 3, 1)
                )
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            63,
            sut.gridGame(
                arrayOf(
                    intArrayOf(20, 3, 20, 17, 2, 12, 15, 17, 4, 15),
                    intArrayOf(20, 10, 13, 14, 15, 5, 2, 3, 14, 3)
                )
            )
        )
    }
}