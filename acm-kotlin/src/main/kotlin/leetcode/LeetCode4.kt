package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode4 {
    private fun Int.isEven(): Boolean {
        return this % 2 == 0
    }

    private fun solve(a: IntArray, b: IntArray): Double {
        val x = a.size
        val y = b.size
        val n = x + y
        var l = 0
        var h = x
        while (l <= h) {
            val px = (l + h) / 2
            val py = (n + 1) / 2 - px

            val maxLftX = if (px == 0) Int.MIN_VALUE else a[px - 1]
            val minRhtX = if (px == x) Int.MAX_VALUE else a[px]

            val maxLftY = if (py == 0) Int.MIN_VALUE else b[py - 1]
            val minRhtY = if (py == y) Int.MAX_VALUE else b[py]

            if (maxLftX <= minRhtY && maxLftY <= minRhtX) {
                return if (n.isEven()) {
                    (max(maxLftX, maxLftY) + min(minRhtX, minRhtY)).toDouble() / 2.0
                } else {
                    max(maxLftX, maxLftY).toDouble()
                }
            } else if (maxLftX > minRhtY) {
                h = px - 1
            } else {
                l = px + 1
            }
        }
        throw IllegalArgumentException()
    }

    fun findMedianSortedArrays(
        nums1: IntArray,
        nums2: IntArray
    ): Double {
        if (nums1.size <= nums2.size) {
            return solve(nums1, nums2)
        } else {
            return solve(nums2, nums1)
        }
    }
}