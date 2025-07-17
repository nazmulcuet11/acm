package leetcode

import kotlin.math.max

class LeetCode3202 {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val n = nums.size
        var answer = 0
        val cache = Array(k) { IntArray(n) { 1 } }
        for (i in 1..<n) {
            for (j in 0..<i) {
                val mod = (nums[i] + nums[j]) % k
                cache[mod][i] = max(cache[mod][i], cache[mod][j] + 1)
                answer = max(answer, cache[mod][i])
            }
        }
        return answer
    }
}