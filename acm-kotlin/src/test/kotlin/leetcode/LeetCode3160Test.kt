package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode3160Test {
    private val sut = LeetCode3160()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(1, 2, 2, 3),
            sut.queryResults(
                4,
                arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(1, 3), intArrayOf(3, 4))
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(1, 2, 2, 3, 4),
            sut.queryResults(
                4,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 2), intArrayOf(3, 4), intArrayOf(4, 5))
            )
        )
    }
}