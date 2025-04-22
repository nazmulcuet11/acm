package leetcode

import kotlin.math.min

class LeetCode2338 {
    fun idealArrays(n: Int, maxValue: Int): Int {

        val mod = 1_000_000_000 + 7

        // uniqueSequenceCount(i, l)  represents number of unique
        // sequence of length l starting at starting at i
        val uscCache = Array(maxValue + 1) { LongArray(15) { -1 } }
        fun uniqueSequenceCount(i: Int, l: Int): Long {
            if (l == 1) {
                return 1
            }

            if (uscCache[i][l] != -1L) {
                return uscCache[i][l]
            }

            var ans = 0L
            var j = i + i
            while (j <= maxValue) {
                ans = (ans  + uniqueSequenceCount(j, l - 1)) % mod
                j += i
            }
            uscCache[i][l] = ans
            return ans
        }


        // expansionCount(x, l) represents number of ways to expand
        // a unique sequence of length x to a sequence of length l
        val ecCache = Array(15) { LongArray(n + 1) { -1 } }
        fun expansionCount(x: Int, l: Int): Long {
            if (x == l) {
                return 1
            }

            if (x == 0 || x > l) {
                return 0
            }

            if (ecCache[x][l] != -1L) {
                return ecCache[x][l]
            }

            var ans = expansionCount(x, l - 1) % mod
            ans = (ans + expansionCount(x - 1, l - 1)) % mod
            ecCache[x][l] = ans
            return ans
        }

        var ans = 0L
        for (i in 1..maxValue) {
            for (l in 1..min(14, n)) {
                val usc = uniqueSequenceCount(i, l)
                val ec = expansionCount(l, n)
                ans = (ans + (usc * ec) % mod) % mod
            }
        }
        return ans.toInt()
    }
}