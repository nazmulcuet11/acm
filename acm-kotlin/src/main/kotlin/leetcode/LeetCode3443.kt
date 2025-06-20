package leetcode

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class LeetCode3443 {
    fun maxDistance(s: String, k: Int): Int {
        fun solve(n: Int, s: Int, e: Int, w: Int): Int {
            var nCount = n
            var sCount = s
            var eCount = e
            var wCount = w

            var remainingAlter = k
            if (nCount > sCount) {
                val numberOfAlter = min(sCount, remainingAlter)
                nCount += numberOfAlter
                sCount -= numberOfAlter
                remainingAlter -= numberOfAlter
            } else {
                val numberOfAlter = min(nCount, remainingAlter)
                sCount += numberOfAlter
                nCount -= numberOfAlter
                remainingAlter -= numberOfAlter
            }

            if (wCount > eCount) {
                val numberOfAlter = min(eCount, remainingAlter)
                wCount += numberOfAlter
                eCount -= numberOfAlter
                remainingAlter -= numberOfAlter
            } else {
                val numberOfAlter = min(wCount, remainingAlter)
                eCount += numberOfAlter
                wCount -= numberOfAlter
                remainingAlter -= numberOfAlter
            }

            // println(nCount)
            // println(sCount)
            // println(wCount)
            // println(eCount)

            return abs(nCount - sCount) + abs(wCount - eCount)
        }

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