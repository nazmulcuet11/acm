package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3342Test {
    private val sut = LeetCode3342()

    @Test
    fun case1() {
        assertEquals(
            7,
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
            6,
            sut.minTimeToReach(
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            4,
            sut.minTimeToReach(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                )
            )
        )
    }
}