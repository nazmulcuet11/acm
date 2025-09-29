package leetcode

import kotlin.math.min

class LeetCode1039 {
    fun minScoreTriangulation(values: IntArray): Int {
        val cache = Array(values.size) { IntArray(values.size) { -1 } }

        fun solve(l: Int, r: Int): Int {
            if (r - l < 2) {
                return 0
            }

            if (cache[l][r] != -1) {
                return cache[l][r]
            }

            var ans = Int.MAX_VALUE
            for (i in l+1..<r) {
                val t = solve(l, i) + solve(i, r) + values[l] * values[r] * values[i]
                ans = min(ans, t)
            }
            cache[l][r] = ans
            return ans
        }

        return solve(0, values.size - 1)
    }
}