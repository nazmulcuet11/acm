package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2140Test {
    private val sut = LeetCode2140()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.mostPoints(
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(4, 3),
                    intArrayOf(4, 4),
                    intArrayOf(2, 5)
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            7,
            sut.mostPoints(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3),
                    intArrayOf(4, 4),
                    intArrayOf(5, 5)
                )
            )
        )
    }
}
