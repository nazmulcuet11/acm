package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode3243Test {
    private val sut = LeetCode3243()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(3, 2, 1),
            sut.shortestDistanceAfterQueries(
                5,
                arrayOf(intArrayOf(2, 4), intArrayOf(0, 2), intArrayOf(0, 4))
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(1, 1),
            sut.shortestDistanceAfterQueries(
                4,
                arrayOf(intArrayOf(0, 3), intArrayOf(0, 2))
            )
        )
    }


    @Test
    fun case3() {
        assertContentEquals(
            intArrayOf(6, 2),
            sut.shortestDistanceAfterQueries(
                8,
                arrayOf(intArrayOf(5, 7), intArrayOf(0, 6))
            )
        )
    }
}