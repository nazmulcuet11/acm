package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode179Test {
    private val sut = LeetCode179()

    @Test
    fun testCaseOne() {
        assertEquals(
            "210",
            sut.largestNumber(intArrayOf(10, 2))
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            "9534330",
            sut.largestNumber(intArrayOf(3, 30, 34, 5, 9))
        )
    }

    @Test
    fun testCaseThree() {
        assertEquals(
            "1113111311",
            sut.largestNumber(intArrayOf(111311, 1113))
        )
    }

    @Test
    fun testCaseFour() {
        assertEquals(
            "0",
            sut.largestNumber(intArrayOf(0, 0))
        )
    }
}