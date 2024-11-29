package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2577Test {
    private val sut = LeetCode2577()

    @Test
    fun case1() {
        assertEquals(
            7,
            sut.minimumTime(
                arrayOf(
                    intArrayOf(0, 1, 3, 2),
                    intArrayOf(5, 1, 2, 5),
                    intArrayOf(4, 3, 8, 6),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            -1,
            sut.minimumTime(
                arrayOf(
                    intArrayOf(0, 2, 4),
                    intArrayOf(3, 2, 1),
                    intArrayOf(1, 0, 4),
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            6,
            sut.minimumTime(
                arrayOf(
                    intArrayOf(0, 1, 99),
                    intArrayOf(3, 99, 99),
                    intArrayOf(4, 5, 6),
                )
            )
        )
    }
}