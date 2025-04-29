package leetcode

class LeetCode2962 {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val maxElement = nums.max()
        var i = 0
        var j = 0
        var count = 0
        var ans = 0L
        while (j < nums.size) {
            if (nums[j] == maxElement) {
                count++
            }

            while (i <= j && count >= k) {
                ans += nums.size - j
                if (nums[i] == maxElement) {
                    count--
                }
                i++
            }

            j++
        }
        return ans
    }
}