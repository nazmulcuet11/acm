package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode39Test {
    private val sut = LeetCode39()

    @Test
    fun testCaseOne() {
        assertEquals(
            listOf(
                listOf(2, 2, 3),
                listOf(7)
            ),
            sut.combinationSum(
                intArrayOf(2, 3, 6, 7),
                7
            )
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            listOf(
                listOf(2, 2, 2, 2),
                listOf(2, 3, 3),
                listOf(3, 5),
            ),
            sut.combinationSum(
                intArrayOf(2, 3, 5),
                8
            )
        )
    }
}