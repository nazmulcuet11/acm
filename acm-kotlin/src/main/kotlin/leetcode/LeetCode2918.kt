package leetcode

import kotlin.math.max

class LeetCode2918 {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        val sum1 = nums1.sumOf { it.toLong() }
        val zeroCount1 = nums1.count { it == 0 }
        val sum2 = nums2.sumOf { it.toLong() }
        val zeroCount2 = nums2.count { it == 0 }

        if (zeroCount1 == 0 && zeroCount2 == 0) {
            return if (sum1 == sum2) sum1 else -1
        }

        if (zeroCount1 == 0) {
            return if (sum2 + zeroCount2 <= sum1) sum1 else -1
        }

        if (zeroCount2 == 0) {
            return if (sum1 + zeroCount1 <= sum2) sum2 else -1
        }

        return max(sum1 + zeroCount1, sum2 + zeroCount2)
    }
}