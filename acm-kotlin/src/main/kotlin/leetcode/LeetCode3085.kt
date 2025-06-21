package leetcode

import kotlin.math.min

class LeetCode3085 {
    fun minimumDeletions(word: String, k: Int): Int {
        fun Char.index() = code - 'a'.code
        val freq = IntArray(26) { 0 }
        for(c in word) {
            freq[c.index()]++
        }

        fun solve(mn: Int, mx: Int): Int {
            var noOfCharToDelete = 0
            for (i in 0..<26) {
                if (freq[i] < mn) {
                    noOfCharToDelete += freq[i]
                } else if (freq[i] > mx) {
                    noOfCharToDelete += freq[i] - mx
                }
            }
            return noOfCharToDelete
        }

        var ans = Int.MAX_VALUE
        for (i in 0..<26) {
            ans = min(ans, solve(freq[i], freq[i] + k))
        }
        return ans
    }
}