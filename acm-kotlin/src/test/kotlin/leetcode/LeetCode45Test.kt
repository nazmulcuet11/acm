package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode45Test {
    private val sut = LeetCode45()

    @Test
    fun testCaseOne() {
        assertEquals(2, sut.jump(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun testCaseTwo() {
        assertEquals(2, sut.jump(intArrayOf(2, 3, 0, 1, 4)))
    }
}