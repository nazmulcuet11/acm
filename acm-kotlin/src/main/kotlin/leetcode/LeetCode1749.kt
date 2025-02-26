package leetcode

import kotlin.math.max

class LeetCode1749 {
    private fun maxSubArraySum(nums: IntArray): Int {
        var i = 0
        var j = 0
        var maxSum = nums.min()
        var currentSum = 0
        while (j < nums.size) {
            currentSum += nums[j]
            j++

            while (i < j && currentSum < 0) {
                currentSum -= nums[i]
                i++
            }

            maxSum = max(maxSum, currentSum)
        }
        return maxSum
    }

    fun maxAbsoluteSum(nums: IntArray): Int {
        val a = maxSubArraySum(nums)
        for (i in nums.indices) {
            nums[i] *= -1
        }
        val b = maxSubArraySum(nums)
        return max(a, b)
    }
}