package leetcode

import kotlin.math.max

class LeetCode2874 {
    fun maximumTripletValue(nums: IntArray): Long {
        val n = nums.size

        val leftMax = IntArray(nums.size)
        leftMax[0] = nums[0]
        for (i in 1..<n) {
            leftMax[i] = max(leftMax[i - 1], nums[i])
        }

        val rightMax = IntArray(nums.size)
        rightMax[n - 1] = nums[n - 1]
        for (i in n - 2 downTo 0) {
            rightMax[i] = max(rightMax[i + 1], nums[i])
        }

        var ans = 0L
        for (i in 1..<n - 1) {
            val value = (leftMax[i - 1] - nums[i]).toLong() * rightMax[i + 1].toLong()
            ans = max(value, ans)
        }
        return ans
    }
}