package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode689Test {
    private val sut = LeetCode689()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(0, 3, 5),
            sut.maxSumOfThreeSubarrays(
                intArrayOf(1, 2, 1, 2, 6, 7, 5, 1),
                2
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(0, 2, 4),
            sut.maxSumOfThreeSubarrays(
                intArrayOf(1, 2, 1, 2, 1, 2, 1, 2, 1),
                2
            )
        )
    }
}