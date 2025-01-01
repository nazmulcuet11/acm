package leetcode

import kotlin.math.max

class LeetCode1422 {
    fun maxScore(s: String): Int {
        var totalOneCount = 0
        for (c in s) {
            if (c == '1') {
                totalOneCount++
            }
        }

        var ans = 0
        var oneCountOnTheLeft = 0
        var zeroCountOnTheLeft = 0
        for (i in 0..<s.length - 1) {
            if (s[i] == '1') {
                oneCountOnTheLeft++
            } else {
                zeroCountOnTheLeft++
            }

            ans = max(ans, zeroCountOnTheLeft + (totalOneCount - oneCountOnTheLeft))
        }

        return ans
    }
}