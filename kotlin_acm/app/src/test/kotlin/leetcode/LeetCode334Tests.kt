package leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

class LeetCode334Tests {
    val sut = LeetCode334()

    @Test
    fun testCase1() {
        assertEquals(true, sut.increasingTriplet(intArrayOf(1,2,3,4,5)))
    }

    @Test
    fun testCase2() {
        assertEquals(false, sut.increasingTriplet(intArrayOf(5,4,3,2,1)))
    }

    @Test
    fun testCase3() {
        assertEquals(true, sut.increasingTriplet(intArrayOf(2,1,5,0,4,6)))
    }
}