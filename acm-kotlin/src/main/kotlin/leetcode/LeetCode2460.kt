package leetcode

class LeetCode2460 {
    fun applyOperations(nums: IntArray): IntArray {
        for (i in 0..<nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0
            }
        }

        var j = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[j] = nums[i]
                if (i != j) {
                    nums[i] = 0
                }
                j++
            }
        }
        return nums
    }
}