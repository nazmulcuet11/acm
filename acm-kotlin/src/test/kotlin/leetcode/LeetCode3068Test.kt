package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class LeetCode3068Test {
    private val sut = LeetCode3068()

    @Test
    fun case1() {
        val nums = intArrayOf(1, 2, 1)
        val k = 3
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertEquals(6L, sut.maximumValueSum(nums, k, edges))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(2, 3)
        val k = 7
        val edges = arrayOf(intArrayOf(0, 1))
        assertEquals(9L, sut.maximumValueSum(nums, k, edges))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(7, 7, 7, 7, 7, 7)
        val k = 3
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2),
            intArrayOf(0, 3), intArrayOf(0, 4),
            intArrayOf(0, 5)
        )
        assertEquals(42L, sut.maximumValueSum(nums, k, edges))
    }

    @Test
    fun case4() {
        val nums = intArrayOf(24, 78, 1, 97, 44)
        val k = 6
        val edges = arrayOf(
            intArrayOf(0, 2), intArrayOf(1, 2),
            intArrayOf(4, 2), intArrayOf(3, 4)
        )
        assertEquals(260L, sut.maximumValueSum(nums, k, edges))
    }

    @Test
    fun case5() {
        val nums = intArrayOf(67, 13, 79, 13, 75, 11, 0, 41, 94)
        val k = 7
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(3, 7),
            intArrayOf(4, 7), intArrayOf(6, 5),
            intArrayOf(6, 0), intArrayOf(0, 2),
            intArrayOf(7, 2), intArrayOf(7, 8)
        )
        assertEquals(407L, sut.maximumValueSum(nums, k, edges))
    }

    @Test
    fun case6() {
        val nums = intArrayOf(49, 67, 81, 34, 32)
        val k = 6
        val edges = arrayOf(
            intArrayOf(1, 0), intArrayOf(4, 0),
            intArrayOf(4, 2), intArrayOf(3, 4)
        )
        assertEquals(283L, sut.maximumValueSum(nums, k, edges))
    }
}
