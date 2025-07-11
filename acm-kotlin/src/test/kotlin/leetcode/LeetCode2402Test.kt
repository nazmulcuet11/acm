package leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeetCode2402Test {
    private val sut = LeetCode2402()

    @Test
    fun testCaseOne() {
        val n = 2
        val meetings = arrayOf(
            intArrayOf(0, 10),
            intArrayOf(1, 5),
            intArrayOf(2, 7),
            intArrayOf(3, 4)
        )
        val expected = 0
        assertEquals(expected, sut.mostBooked(n, meetings))
    }

    @Test
    fun testCaseTwo() {
        val n = 3
        val meetings = arrayOf(
            intArrayOf(1, 20),
            intArrayOf(2, 10),
            intArrayOf(3, 5),
            intArrayOf(4, 9),
            intArrayOf(6, 8)
        )
        val expected = 1
        assertEquals(expected, sut.mostBooked(n, meetings))
    }

    @Test
    fun testCaseThree() {
        val n = 4
        val meetings = arrayOf(
            intArrayOf(19, 20),
            intArrayOf(14, 15),
            intArrayOf(13, 14),
            intArrayOf(11, 20)
        )
        val expected = 1
        assertEquals(expected, sut.mostBooked(n, meetings))
    }
}
