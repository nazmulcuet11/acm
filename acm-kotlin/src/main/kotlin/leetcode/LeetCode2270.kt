package leetcode

class LeetCode2270 {
    fun waysToSplitArray(nums: IntArray): Int {
        val total = nums.sumOf { it.toLong() }
        var ans = 0
        var current = 0L
        for (i in 0..<nums.size - 1) {
            current += nums[i]
            if (current >= (total - current)) {
                ans++
            }
        }
        return ans
    }
}