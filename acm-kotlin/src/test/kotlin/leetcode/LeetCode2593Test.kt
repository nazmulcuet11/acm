package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2593Test {
    private val sut = LeetCode2593()

    @Test
    fun case1() {
        assertEquals(
            7,
            sut.findScore(intArrayOf(2, 1, 3, 4, 5, 2))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            5,
            sut.findScore(intArrayOf(2, 3, 5, 1, 3, 2))
        )
    }
}