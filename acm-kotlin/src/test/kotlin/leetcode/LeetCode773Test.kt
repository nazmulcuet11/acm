package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode773Test {
    private val sut = LeetCode773()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.slidingPuzzle(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 0, 5),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            -1,
            sut.slidingPuzzle(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(5, 4, 0),
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            5,
            sut.slidingPuzzle(
                arrayOf(
                    intArrayOf(4, 1, 2),
                    intArrayOf(5, 0, 3),
                )
            )
        )
    }
}