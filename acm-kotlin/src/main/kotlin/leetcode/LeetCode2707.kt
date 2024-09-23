package leetcode

import kotlin.math.min

class LeetCode2707 {
    private var s = ""
    private var words = setOf<String>()
    private var cache = mutableMapOf<Int, Int>()

    private fun solve(i: Int): Int {
        if (i == s.length) {
            return 0
        }

        cache[i]?.let {
            return it
        }

        var result = 1 + solve(i + 1) // skip
        for (j in i until s.length) {
            val word = s.substring(i, j + 1)
            if (words.contains(word)) {
                result = min(result, solve(j + 1))
            }
        }
        cache[i] = result
        return result
    }

    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        this.s = s
        words = dictionary.toSet()
        cache = mutableMapOf<Int, Int>()
        return solve(0)
    }
}
