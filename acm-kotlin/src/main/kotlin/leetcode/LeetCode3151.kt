package leetcode

class LeetCode3151 {
    fun isArraySpecial(nums: IntArray): Boolean {
        for (i in 1..<nums.size) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                return false
            }
        }
        return true
    }
}