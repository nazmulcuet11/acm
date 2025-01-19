package leetcode.Weekly433

import kotlin.math.min

class Question3 {
    private companion object {
        const val INFINITY = Long.MAX_VALUE
    }

    private var n = 0
    private var cost = Array(0) { intArrayOf() }
    private var cache = Array(0) { Array(0) { longArrayOf() } }

    fun solve(i: Int, a: Int, b: Int): Long {
        val j = n - 1 - i
        if (i > j) {
            return 0
        }

        if (cache[i][a + 1][b + 1] != -1L) {
            return cache[i][a + 1][b + 1]
        }

        var ans = INFINITY
        for (x in 0..2) {
            if (a != x) {
                for (y in 0..2) {
                    if (y != b && y != x) {
                        val t = solve(i + 1, x, y) + cost[i][x] + cost[j][y]
                        ans = min(ans, t)
                    }
                }
            }
        }
        cache[i][a + 1][b + 1] = ans
        return ans
    }

    fun minCost(n: Int, cost: Array<IntArray>): Long {
        this.n = n
        this.cost = cost
        this.cache = Array(n) { Array(4) { LongArray(4) { -1L } } }

        return solve(0, -1, -1)
    }
}