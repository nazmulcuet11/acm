package leetcode

class LeetCode3355 {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val delta = IntArray(nums.size + 1) { 0 }
        for (q in queries) {
            delta[q[0]]++
            delta[q[1] + 1]--
        }

        for (i in 1..<delta.size) {
            delta[i] += delta[i - 1]
        }

        for (i in nums.indices) {
            if (nums[i] > delta[i]) {
                return false
            }
        }
        return true
    }
}