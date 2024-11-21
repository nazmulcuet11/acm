package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2257Test {
    private val sut = LeetCode2257()

    @Test
    fun case1() {
        assertEquals(
            7,
            sut.countUnguarded(
                4,
                6,
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(2, 3),
                ),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(2, 2),
                    intArrayOf(1, 4),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.countUnguarded(
                3,
                3,
                arrayOf(
                    intArrayOf(1, 1),
                ),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0),
                    intArrayOf(2, 1),
                    intArrayOf(1, 2),
                )
            )
        )
    }
}