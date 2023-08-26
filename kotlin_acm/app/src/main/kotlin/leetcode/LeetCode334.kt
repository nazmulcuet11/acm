package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode334 {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3)
            return false
        var minInLeft = nums.toMutableList()
        for (i in 1..<nums.size)
            minInLeft[i] = min(minInLeft[i], minInLeft[i - 1])

        var maxInRight = nums.toMutableList()
        for (i in nums.size - 2 downTo 0)
            maxInRight[i] = max(maxInRight[i], maxInRight[i + 1])

        for (i in nums.indices)
            if (minInLeft[i] < nums[i] && nums[i] < maxInRight[i])
                return true
        return  false
    }
}