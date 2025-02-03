package leetcode

import kotlin.math.max

class LeetCode3105 {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        var i = 0
        while (i < n) {
            var j = i + 1
            while (j < n && nums[j] > nums[j - 1]) {
                j++
            }
            ans = max(ans, j - i)
            i = j
        }

        i = 0
        while (i < n) {
            var j = i + 1
            while (j < n && nums[j] < nums[j - 1]) {
                j++
            }
            ans = max(ans, j - i)
            i = j
        }
        return ans
    }
}