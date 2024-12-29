package leetcode

import kotlin.math.max

class LeetCode1639 {
    private companion object {
        const val MAX_LEN = 1000 + 5
        const val MOD = 1000_000_000 + 7
    }

    private val indexCharCount = Array<MutableMap<Char, Int>>(MAX_LEN) { mutableMapOf() }
    private var maxWordLength = 0
    private var target = ""
    private var cache = Array(MAX_LEN) { Array(MAX_LEN) { -1L } }

    private fun solve(i: Int, j: Int): Long {
        if (j == target.length) {
            return 1
        }
        if (i == maxWordLength) {
            return 0
        }

        if (cache[i][j] != -1L) {
            return cache[i][j]
        }

        // skip matching from ith index
        var ans = solve(i + 1, j) % MOD
        // match from ith index
        indexCharCount[i][target[j]]?.let {
            val a = solve(i + 1, j + 1) % MOD
            ans = (ans + (a * it) % MOD) % MOD
        }
        cache[i][j] = ans
        return ans
    }

    fun numWays(words: Array<String>, target: String): Int {
        this.target = target
        for (w in words) {
            maxWordLength = max(maxWordLength, w.length)
            for ((i, c) in w.withIndex()) {
                indexCharCount[i][c] = indexCharCount[i].getOrDefault(c, 0) + 1
            }
        }
        return solve(0, 0).toInt()
    }
}