package leetcode

import kotlin.math.max

class LeetCode2014 {
    fun longestSubsequenceRepeatedK(s: String, k: Int): String {
        val charCount = mutableMapOf<Char, Int>()
        for (c in s) {
            charCount[c] = charCount.getOrDefault(c, 0) + 1
        }

        val candidateChars = mutableListOf<Char>()
        for ((c, v) in charCount) {
            if (v >= k) {
                candidateChars.add(c)
            }
        }

        candidateChars.sortDescending()

        var maxRepetitionInSingleSequence = Int.MIN_VALUE
        for (c in candidateChars) {
            val count = charCount.getOrDefault(c, 0)
            maxRepetitionInSingleSequence = max(maxRepetitionInSingleSequence, count / k)
        }

        fun isKRepeatingSub(sub: String): Boolean {
            var matchStart = 0
            fun hasMatch(): Boolean {
                var i = matchStart
                var j = 0
                while (i < s.length && j < sub.length) {
                    if (s[i] == sub[j]) {
                        j++
                    }
                    i++
                }

                matchStart = i
                return j == sub.length
            }

            var count = 0
            while (count < k && hasMatch()) {
                count++
            }
            return count >= k
        }

        var ans = ""
        val takenCount = mutableMapOf<Char, Int>()
        val sb = StringBuilder()
        fun generate() {
            val sub = sb.toString()
            if (sub.isNotEmpty() && !isKRepeatingSub(sub)) {
                return
            }

            if (ans.length < sub.length) {
                ans = sub
            }

            for (c in candidateChars) {
                if (takenCount.getOrDefault(c, 0) < maxRepetitionInSingleSequence) {
                    sb.append(c)
                    takenCount[c] = takenCount.getOrDefault(c, 0) + 1
                    generate()
                    sb.deleteCharAt(sb.length - 1)
                    takenCount[c] = takenCount.getOrDefault(c, 0) - 1
                }
            }
        }

        generate()
        return ans
    }
}