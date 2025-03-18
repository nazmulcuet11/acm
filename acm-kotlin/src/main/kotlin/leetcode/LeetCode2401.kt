package leetcode

import kotlin.math.max

class LeetCode2401 {
    fun longestNiceSubarray(nums: IntArray): Int {
        var i = 0
        var j = 0
        var ans = 0
        var x = 0
        while (j < nums.size) {
            while (i < j && x and nums[j] > 0) {
                x = x xor nums[i]
                i++
            }

            x = x or nums[j]
            j++
            ans = max(ans, j - i)
        }
        return ans
    }
}