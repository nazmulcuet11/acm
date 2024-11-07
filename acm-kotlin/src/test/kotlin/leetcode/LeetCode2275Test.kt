package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2275Test {
    private val sut = LeetCode2275()

    @Test
    fun testCase1() {
        assertEquals(
            4,
            sut.largestCombination(intArrayOf(16, 17, 71, 62, 12, 24, 14))
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            2,
            sut.largestCombination(intArrayOf(8, 8))
        )
    }
}