package leetcode

import kotlin.math.min

class LeetCode2444 {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var ans = 0L
        var lastMinIndex = -1
        var lastMaxIndex = -1
        var lastBadIndex = -1
        for ((i, n) in nums.withIndex()) {
            if (n == minK) {
                lastMinIndex = i
            }
            if (n == maxK) {
                lastMaxIndex = i
            }
            if (n < minK || n > maxK) {
                lastBadIndex = i
            }

            if (lastMinIndex != -1 && lastMaxIndex != -1 && lastBadIndex < min(lastMinIndex, lastMaxIndex)) {
                ans += min(lastMinIndex, lastMaxIndex) - lastBadIndex
            }
        }
        return ans
    }
}