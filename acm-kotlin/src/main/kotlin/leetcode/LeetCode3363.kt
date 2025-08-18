package leetcode

import kotlin.math.max

class LeetCode3363 {
    fun maxCollectedFruits(fruits: Array<IntArray>): Int {
        val n = fruits.size

        var ans = 0
        for (i in 0..<n) {
            ans += fruits[i][i]
            fruits[i][i] = 0
        }

        var dp = Array(n) { IntArray(n) { 0 } }
        var x = n - 1
        for (i in 0..<n) {
            for (j in x..<n) {
                var maxPrev = 0
                if (i - 1 in 0..<n && j - 1 in 0..<n) {
                    maxPrev = max(maxPrev, dp[i - 1][j - 1])
                }

                if (i - 1 in 0..<n) {
                    maxPrev = max(maxPrev, dp[i - 1][j])
                }

                if (i - 1 in 0..<n && j + 1 in 0..<n) {
                    maxPrev = max(maxPrev, dp[i - 1][j + 1])
                }

                dp[i][j] = maxPrev + fruits[i][j]
            }

            if (i < (n - 1) / 2) {
                x--
            } else {
                x++
            }
        }
//        println(dp.map { it.toList() })
        ans += dp[n - 2][n - 1]

        dp = Array(n) { IntArray(n) { 0 } }
        x = n - 1
        for (j in 0..<n) {
            for (i in x..<n) {
                var maxPrev = 0
                if (i - 1 in 0..<n && j - 1 in 0..<n) {
                    maxPrev = max(maxPrev, dp[i - 1][j - 1])
                }

                if (j - 1 in 0..<n) {
                    maxPrev = max(maxPrev, dp[i][j - 1])
                }

                if (i + 1 in 0..<n && j - 1 in 0..<n) {
                    maxPrev = max(maxPrev, dp[i + 1][j - 1])
                }

                dp[i][j] = maxPrev + fruits[i][j]
            }

            if (j < (n - 1) / 2) {
                x--
            } else {
                x++
            }
        }

//        println(dp.map { it.toList() })
        ans += dp[n - 1][n - 2]

        return ans
    }
}