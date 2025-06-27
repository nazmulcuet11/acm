package leetcode

import kotlin.math.max
import kotlin.math.min

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

        var ans = ""
        fun updateAnsIfNeeded(sub: String) {
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
            if (count >= k) {
                ans = sub
            }
        }

        fun tryToGenerateAns(len: Int) {
            val takenCount = mutableMapOf<Char, Int>()
            val  sb = StringBuilder()
            fun solve() {
                if (ans != "") {
                    // no need to try more
                    return
                }

                if (sb.length == len) {
                    val sub = sb.toString()
                    updateAnsIfNeeded(sub)
                    return
                }

                for (c in candidateChars) {
                    if (takenCount.getOrDefault(c, 0) < maxRepetitionInSingleSequence) {
                        sb.append(c)
                        takenCount[c] = takenCount.getOrDefault(c, 0) + 1
                        solve()
                        sb.deleteCharAt(sb.length - 1)
                        takenCount[c] = takenCount.getOrDefault(c, 0) - 1
                    }
                }
            }

            solve()
        }

        val maxLen = min(s.length / k, maxRepetitionInSingleSequence * candidateChars.size)
        for (len in maxLen downTo 1) {
            tryToGenerateAns(len)
            if (ans != "") {
                break
            }
        }
        return ans
    }
}