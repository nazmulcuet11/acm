package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3169Test {
    private val sut = LeetCode3169()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.countDays(
                10,
                arrayOf(intArrayOf(5, 7), intArrayOf(1, 3), intArrayOf(9, 10))
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.countDays(
                5,
                arrayOf(intArrayOf(2, 4), intArrayOf(1, 3))
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            0,
            sut.countDays(
                6,
                arrayOf(intArrayOf(1, 6))
            )
        )
    }
}