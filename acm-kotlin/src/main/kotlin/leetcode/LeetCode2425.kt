package leetcode

class LeetCode2425 {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        var ans = 0
        if (nums2.size % 2 == 1) {
            for (n in nums1) {
                ans = ans xor n
            }
        }
        if (nums1.size % 2 == 1) {
            for (n in nums2) {
                ans = ans xor n
            }
        }
        return ans
    }
}