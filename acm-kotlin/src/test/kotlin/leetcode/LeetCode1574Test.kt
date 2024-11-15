package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1574Test {
    private val sut = LeetCode1574()

    @Test
    fun testCase1() {
        assertEquals(
            3,
            sut.findLengthOfShortestSubarray(intArrayOf(1, 2, 3, 10, 4, 2, 3, 5))
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            4,
            sut.findLengthOfShortestSubarray(intArrayOf(5, 4, 3, 2, 1))
        )
    }

    @Test
    fun testCase3() {
        assertEquals(
            0,
            sut.findLengthOfShortestSubarray(intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun testCase4() {
        assertEquals(
            2,
            sut.findLengthOfShortestSubarray(intArrayOf(1, 2, 3, 10, 0, 7, 8, 9))
        )
    }
}