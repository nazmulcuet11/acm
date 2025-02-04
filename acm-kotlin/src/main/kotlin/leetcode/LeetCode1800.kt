package leetcode

import kotlin.math.max

class LeetCode1800 {
    fun maxAscendingSum(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        var i = 0
        while (i < n) {
            var sum = nums[i]
            var j = i + 1
            while (j < n && nums[j - 1] < nums[j]) {
                sum += nums[j]
                j++
            }
            ans = max(ans, sum)
            i = j
        }
        return ans
    }
}