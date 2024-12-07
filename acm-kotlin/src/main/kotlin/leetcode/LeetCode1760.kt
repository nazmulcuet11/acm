package leetcode

import kotlin.math.ceil

class LeetCode1760 {
    private fun minOperation(nums: IntArray, n: Int): Int {
        var sum = 0
        for (v in nums) {
            sum += ceil(v.toDouble() / n.toDouble()).toInt() - 1
        }
        return sum
    }
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        var l = 1
        var h = nums.max()
        while (l < h) {
            val m = l + (h - l) / 2
            if (minOperation(nums, m) > maxOperations) {
                l = m + 1
            } else {
                h = m
            }
        }
        return l
    }
}
