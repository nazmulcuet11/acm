package leetcode

import kotlin.math.max

class LeetCode1751 {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        events.sortBy { it[0] }

        fun next(i: Int): Int {
            for (j in i + 1..<events.size) {
                if (events[i][1] < events[j][0]) {
                    return j
                }
            }
            return events.size
        }

        val cache = Array(events.size) { IntArray(k + 1) { -1 } }

        fun solve(i: Int, r: Int): Int {
            if (i == events.size || r == 0) {
                return 0
            }

            if (cache[i][r] != -1) {
                return cache[i][r]
            }

            val a = solve(next(i), r - 1) + events[i][2]
            val b = solve(i + 1, r)
            val ans = max(a, b)
            cache[i][r] = ans
            return ans
        }

        return solve(0, k)
    }
}