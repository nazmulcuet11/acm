package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1014Test {
    private val sut = LeetCode1014()

    @Test
    fun case1() {
        assertEquals(
            11,
            sut.maxScoreSightseeingPair(intArrayOf(8, 1, 5, 2, 6))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.maxScoreSightseeingPair(intArrayOf(1, 2))
        )
    }
}