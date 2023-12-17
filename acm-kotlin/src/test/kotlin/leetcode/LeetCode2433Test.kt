package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode2433Test {
    private val sut = LeetCode2433()
    @Test
    fun testCaseOne() {
        assertArrayEquals(
            intArrayOf(5, 7, 2, 3, 2),
            sut.findArray(intArrayOf(5, 2, 0, 3, 1))
        )
    }

    @Test
    fun testCaseTwo() {
        assertArrayEquals(
            intArrayOf(13),
            sut.findArray(intArrayOf(13))
        )
    }
}