package leetcode

class LeetCode3191 {
    fun minOperations(nums: IntArray): Int {
        var ans = 0
        for (i in nums.indices) {
            if (nums[i] == 0) {
                if (i + 2 >= nums.size) {
                    return -1
                }

                for (j in i..i+2) {
                    nums[j] = nums[j] xor 1
                }
                ans++
            }
        }
        return ans
    }
}