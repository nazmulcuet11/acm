package leetcode

class LeetCode2419 {
    fun longestSubarray(nums: IntArray): Int {
        val m = nums.max()
        var maxLength = 1
        var currLength = 0
        for (n in nums) {
            if (n == m) {
                currLength++
            } else {
                maxLength = maxOf(maxLength, currLength)
                currLength = 0
            }
        }
        maxLength = maxOf(maxLength, currLength)
        return maxLength
    }
}