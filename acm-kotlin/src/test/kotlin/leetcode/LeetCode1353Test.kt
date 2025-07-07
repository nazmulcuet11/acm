package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1353Test {
    private val sut = LeetCode1353()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.maxEvents(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4)
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.maxEvents(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 2)
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            5,
            sut.maxEvents(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 2),
                    intArrayOf(3, 3),
                    intArrayOf(1, 5),
                    intArrayOf(1, 5)
                )
            )
        )
    }
}
