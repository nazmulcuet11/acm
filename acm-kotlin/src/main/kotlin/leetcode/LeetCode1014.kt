package leetcode

import kotlin.math.max

class LeetCode1014 {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        val n = values.size
        val maxRight = IntArray(n) { 0 }
        for (i in n - 1 downTo 0) {
            maxRight[i] = values[i] - i
            if (i < n - 1) {
                maxRight[i] = max(maxRight[i], maxRight[i + 1])
            }
        }

        var ans = 0
        for (i in 0..<n - 1) {
            ans = max(ans, values[i] + i + maxRight[i + 1])
        }
        return ans
    }
}