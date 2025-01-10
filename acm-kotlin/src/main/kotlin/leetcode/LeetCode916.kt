package leetcode

import kotlin.math.max

class LeetCode916 {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val maxCharCount = mutableMapOf<Char, Int>()
        for (w in words2) {
            val charCount = mutableMapOf<Char, Int>()
            for (c in w) {
                charCount[c] = charCount.getOrDefault(c, 0) + 1
            }

            for ((c, v) in charCount) {
                maxCharCount[c] = max(maxCharCount.getOrDefault(c, 0), v)
            }
        }

        val universal = mutableListOf<String>()
        for (w in words1) {
            val charCount = mutableMapOf<Char, Int>()
            for (c in w) {
                charCount[c] = charCount.getOrDefault(c, 0) + 1
            }

            var isUniversal = true
            for ((c, m) in maxCharCount) {
                if (charCount.getOrDefault(c, 0) < m) {
                    isUniversal = false
                    break
                }
            }
            if (isUniversal) {
                universal.add(w)
            }
        }
        return universal
    }
}