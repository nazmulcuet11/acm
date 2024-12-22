package leetcode

import kotlin.math.min

class LeetCode3399 {
    private fun flipNeededForAlternatePatternStarting(s: String, start: Char): Int {
        var ans = 0
        var expected = start
        for (c in s) {
            if (c != expected) {
                ans++
            }
            expected = if (expected == '0') '1' else '0'
        }
        return ans
    }

    private fun flipNeededForAlternatePattern(s: String): Int {
        return min(
            flipNeededForAlternatePatternStarting(s, '0'),
            flipNeededForAlternatePatternStarting(s, '1')
        )
    }
    private fun flipNeededForStreak(s: String, streak: Int): Int {
        if (streak == 1) {
            return flipNeededForAlternatePattern(s)
        }

        var ans = 0
        var i = 0
        while (i < s.length) {
            var j = i
            while (j < s.length && s[i] == s[j])
                j++
            val l = j - i
            ans += l / (streak + 1)
            i = j
        }
        return ans
    }

    fun minLength(s: String, numOps: Int): Int {
        var l = 1
        var r = s.length
        while (l < r) {
            val m = l + (r - l) / 2
            if (flipNeededForStreak(s, m) <= numOps) {
                r = m
            } else {
                l = m + 1
            }
        }
        return l
    }
}