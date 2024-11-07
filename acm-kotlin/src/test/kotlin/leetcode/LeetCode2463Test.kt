package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode2463Test {
    private val sut = LeetCode2463()

    @Test
    fun testCaseOne() {
        assertEquals(
            4,
            sut.minimumTotalDistance(
                listOf(0, 4, 6),
                arrayOf(
                    intArrayOf(2, 2),
                    intArrayOf(6, 2),
                )
            )
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            2,
            sut.minimumTotalDistance(
                listOf(1, -1),
                arrayOf(
                    intArrayOf(-2, 1),
                    intArrayOf(2, 1),
                )
            )
        )
    }
}