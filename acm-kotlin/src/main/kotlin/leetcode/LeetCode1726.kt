package leetcode

class LeetCode1726 {
    fun tupleSameProduct(nums: IntArray): Int {
        val count = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            for (j in i + 1..<nums.size) {
                val n = nums[i] * nums[j]
                count[n] = count.getOrDefault(n, 0) + 1
            }
        }

        var ans = 0
        for ((k, v) in count) {
            ans += v * (v - 1) * 4
        }
        return ans
    }
}