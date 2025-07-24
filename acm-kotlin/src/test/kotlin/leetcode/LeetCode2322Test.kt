package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2322Test {
    private val sut = LeetCode2322()

    @Test
    fun case1() {
        val nums = intArrayOf(1, 5, 5, 4, 11)
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(3, 4)
        )
        assertEquals(9, sut.minimumScore(nums, edges))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(5, 5, 2, 4, 4, 2)
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(5, 2),
            intArrayOf(4, 3),
            intArrayOf(1, 3)
        )
        assertEquals(0, sut.minimumScore(nums, edges))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(9, 14, 2, 1)
        val edges = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(3, 0),
            intArrayOf(3, 1)
        )
        assertEquals(11, sut.minimumScore(nums, edges))
    }
}
