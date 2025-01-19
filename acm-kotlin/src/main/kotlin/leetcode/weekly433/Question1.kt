package leetcode.weekly433

import kotlin.math.max

class Question1 {
    fun subarraySum(nums: IntArray): Int {
        val prefixSum = nums.copyOf()
        for (i in 1..<prefixSum.size) {
            prefixSum[i] += prefixSum[i - 1]
        }
        var ans = 0
        for (i in nums.indices) {
            val start = max(0, i - nums[i])
            var sum = prefixSum[i]
            if (start > 0) {
                sum -= prefixSum[start - 1]
            }
            ans += sum
        }
        return ans
    }
}