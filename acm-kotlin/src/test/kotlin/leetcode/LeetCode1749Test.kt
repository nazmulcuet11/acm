package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1749Test {
    private val sut = LeetCode1749()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.maxAbsoluteSum(intArrayOf(1, -3, 2, 3, -4))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            8,
            sut.maxAbsoluteSum(intArrayOf(2, -5, 1, -4, 3, -2))
        )
    }
}