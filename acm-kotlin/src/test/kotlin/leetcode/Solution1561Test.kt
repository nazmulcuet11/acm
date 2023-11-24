package leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Solution1561Test {

    val sut = Solution1561()

    @Test
    fun testCaseOne() {
        assertEquals(9, sut.maxCoins(intArrayOf(2, 4, 1, 2, 7, 8)))
    }

    @Test
    fun testCaseTwo() {
        assertEquals(4, sut.maxCoins(intArrayOf(2, 4, 5)))
    }

    @Test
    fun testCaseThree() {
        assertEquals(18, sut.maxCoins(intArrayOf(9, 8, 7, 6, 5, 1, 2, 3, 4)))
    }
}