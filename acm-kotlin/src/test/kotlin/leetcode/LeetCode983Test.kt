package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode983Test {
    private val sut = LeetCode983()

    @Test
    fun case1() {
        assertEquals(
            11,
            sut.mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            17,
            sut.mincostTickets(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31), intArrayOf(2, 7, 15))
        )
    }
}