package leetcode.weekly432

import kotlin.math.max

class Question2 {
    fun maximumAmount(coins: Array<IntArray>): Int {
        val m = coins.size
        val n = coins[0].size
        val cache = Array(m) { Array(n) { Array(3) { -1 } } }

        cache[0][0][0] = coins[0][0]
        cache[0][0][1] = max(coins[0][0], 0)
        cache[0][0][2] = max(coins[0][0], 0)

        for (i in 1..<m) {
            for (k in 0..<3) {
                cache[i][0][k] = cache[i - 1][0][k] + coins[i][0]
                if (coins[i][0] < 0 && k > 0) {
                    cache[i][0][k] = max(
                        cache[i][0][k],
                        cache[i - 1][0][k - 1]
                    )
                }
            }
        }

        for (j in 1..<m) {
            for (k in 0..<3) {
                cache[0][j][k] = cache[0][j - 1][k] + coins[0][j]
                if (coins[0][j] < 0 && k > 0) {
                    cache[0][j][k] = max(
                        cache[0][j][k],
                        cache[0][j - 1][k - 1]
                    )
                }
            }
        }

        for (i in 1..<m) {
            for (j in 1..<n) {
                for (k in 0..<3) {
                    cache[i][j][k] = max(cache[i][j - 1][k], cache[i - 1][j][k]) + coins[i][j]
                    if (coins[i][j] < 0 && k > 0) {
                        cache[i][j][k] = max(
                            cache[i][j][k],
                            max(cache[i][j - 1][k - 1], cache[i - 1][j][k - 1])
                        )
                    }
                }
            }
        }

        return cache[m - 1][n - 1][2]
    }
}