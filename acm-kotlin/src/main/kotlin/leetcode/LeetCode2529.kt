package leetcode

import kotlin.math.max

class LeetCode2529 {
    fun maximumCount(nums: IntArray): Int {
        var posCount = 0
        var negCount = 0
        for (n in nums) {
            if (n > 0) {
                posCount++
            } else if (n < 0) {
                negCount++
            }
        }
        return max(posCount, negCount)
    }
}