package leetcode

import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertTrue

class LeetCode1792Test {
    private companion object {
        const val THRESHOLD = 0.00001
    }
    private val sut = LeetCode1792()

    @Test
    fun case1() {
        val expected = 0.78333
        val actual = sut.maxAverageRatio(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(2, 2)),
            2
        )
        assertTrue { abs(actual - expected) <= THRESHOLD }
    }

    @Test
    fun case2() {
        val expected = 0.53485
        val actual = sut.maxAverageRatio(
            arrayOf(intArrayOf(2, 4), intArrayOf(3, 9), intArrayOf(4, 5), intArrayOf(2, 10)),
            4
        )
        assertTrue { abs(actual - expected) <= THRESHOLD }
    }
}