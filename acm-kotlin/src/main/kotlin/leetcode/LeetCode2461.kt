package leetcode

import kotlin.math.max

class LeetCode2461 {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        val seen = mutableSetOf<Int>()
        var sum = 0L
        var ans = 0L
        var l = 0
        var r = 0
        while (r < nums.size) {
            while (seen.contains(nums[r]) || r - l >= k) {
                sum -= nums[l]
                seen.remove(nums[l])
                l++
            }

            sum += nums[r]
            seen.add(nums[r])
            r++

            if (r - l == k) {
                ans = max(ans, sum)
            }
        }
        return ans
    }
}