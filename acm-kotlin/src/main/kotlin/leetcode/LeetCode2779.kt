package leetcode

import kotlin.math.max

class LeetCode2779 {
    private companion object {
        const val OFFSET = 100005
    }

    fun maximumBeauty(nums: IntArray, k: Int): Int {
        val count = IntArray(3 * OFFSET) { 0 }
        for (n in nums) {
            count[n + OFFSET - k] += 1
            count[n + OFFSET + k + 1] -= 1
        }
        var ans = count[0]
        for (i in 1..<count.size) {
            count[i] += count[i-1]
            ans = max(ans, count[i])
        }
        return ans
    }
}