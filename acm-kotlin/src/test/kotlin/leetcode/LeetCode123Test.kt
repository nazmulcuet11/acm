package leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeetCode123Test {
    private val sut = LeetCode123()

    @Test
    fun testCaseOne() {
        assertEquals(
            6,
            sut.maxProfit(intArrayOf(3,3,5,0,0,3,1,4))
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            4,
            sut.maxProfit(intArrayOf(1,2,3,4,5))
        )
    }

    @Test
    fun testCaseThree() {
        assertEquals(
            0,
            sut.maxProfit(intArrayOf(7,6,4,3,1))
        )
    }

    @Test
    fun testCaseFour() {
        assertEquals(
            13,
            sut.maxProfit(intArrayOf(1,2,4,2,5,7,2,4,9,0))
        )
    }
}