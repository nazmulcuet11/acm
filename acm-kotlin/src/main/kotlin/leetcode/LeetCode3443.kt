package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode3443 {
    fun maxDistance(s: String, k: Int): Int {
        fun solve(a: Int, b: Int, k: Int) = max(a, b) - min(a, b) + 2 * minOf(a, b, k)
        fun solve(n: Int, s: Int, e: Int, w: Int) = solve(n, s, k) + solve(e, w, k - minOf(n, s, k))

        var nCount = 0
        var sCount = 0
        var eCount = 0
        var wCount = 0
        var ans = 0

        for(c in s) {
            if (c == 'N') {
                nCount++
            } else if (c == 'S') {
                sCount++
            } else if (c == 'E') {
                eCount++
            } else if (c == 'W') {
                wCount++
            }

            ans = max(ans, solve(nCount, sCount, eCount, wCount))
        }

        return ans
    }
}