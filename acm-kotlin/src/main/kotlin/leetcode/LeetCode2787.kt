package leetcode

import kotlin.math.pow

class LeetCode2787 {
    companion object {
        const val MOD = 1_000_000_000 + 7
    }

    fun numberOfWays(n: Int, x: Int): Int {

        fun pow(b: Int, p: Int) = b.toDouble().pow(p).toInt()
        val cache = Array(n + 1) { IntArray(n + 1) { -1 } }

        fun solve(i: Int, r: Int): Int {
            if (r == 0) {
                return 1
            }

            val p = pow(i, x)

            if (r < 0 || p > r) {
                return 0
            }

            if (cache[i][r] != -1) {
                return cache[i][r]
            }

            val res = (solve(i + 1, r - p) + solve(i + 1, r)) % MOD
            cache[i][r] = res
            return res
        }

        return solve(1, n)
    }
}