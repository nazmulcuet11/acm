package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode149Test {
    val sut = LeetCode149()

    @Test
    fun testCaseOne() {
        val input  = arrayOf(
            intArrayOf(1,1),
            intArrayOf(2,2),
            intArrayOf(3,3),
        )
        assertEquals(3, sut.maxPoints(input))
    }

    @Test
    fun testCaseTwo() {
        val input  = arrayOf(
            intArrayOf(1,1),
            intArrayOf(3,2),
            intArrayOf(5,3),
            intArrayOf(4,1),
            intArrayOf(2,3),
            intArrayOf(1,4),
        )
        assertEquals(4, sut.maxPoints(input))
    }

    @Test
    fun testCaseThree() {
        val input  = arrayOf(
            intArrayOf(0,0),
        )
        assertEquals(1, sut.maxPoints(input))
    }
}