package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3341Test {
    private val sut = LeetCode3341()

    @Test
    fun case1() {
        assertEquals(
            6,
            sut.minTimeToReach(
                arrayOf(
                    intArrayOf(0, 4),
                    intArrayOf(4, 4),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            3,
            sut.minTimeToReach(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 0),
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            3,
            sut.minTimeToReach(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                )
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            39,
            sut.minTimeToReach(
                arrayOf(
                    intArrayOf(56, 93),
                    intArrayOf(3, 38),
                )
            )
        )
    }
}