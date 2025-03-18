package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2401Test {
    private val sut = LeetCode2401()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.longestNiceSubarray(intArrayOf(1, 3, 8, 48, 10))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.longestNiceSubarray(intArrayOf(3, 1, 5, 11, 13))
        )
    }
}