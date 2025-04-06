package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode368Test {

    private val sut = LeetCode368()

    @Test
    fun case1() {
        assertContentEquals(
            listOf(1, 2),
            sut.largestDivisibleSubset(
                intArrayOf(1, 2, 3)
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            listOf(1, 2, 4, 8),
            sut.largestDivisibleSubset(
                intArrayOf(1, 2, 4, 8)
            )
        )
    }

    @Test
    fun case3() {
        assertContentEquals(
            listOf(9, 18, 90, 180, 360, 720),
            sut.largestDivisibleSubset(
                intArrayOf(5, 9, 18, 54, 108, 540, 90, 180, 360, 720)
            )
        )
    }
}
