package leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeetCode4Test {
    private val sut = LeetCode4()

    @Test
    fun testCaseOne() {
        assertEquals(
            2.0,
            sut.findMedianSortedArrays(
                intArrayOf(1, 3),
                intArrayOf(2),
            )
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            2.5,
            sut.findMedianSortedArrays(
                intArrayOf(1, 2),
                intArrayOf(3, 4),
            )
        )
    }

    @Test
    fun testCaseThree() {
        assertEquals(
            2.5,
            sut.findMedianSortedArrays(
                intArrayOf(),
                intArrayOf(2, 3),
            )
        )
    }
}