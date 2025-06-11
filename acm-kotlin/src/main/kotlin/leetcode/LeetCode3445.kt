package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode3445 {
    fun maxDifference(s: String, k: Int): Int {
        val n = s.length
        fun Int.parity() = this % 2
        fun Int.inverseParity() = parity() xor 1
        fun comboIndex(a: Int, b: Int) = (a.parity() shl 1) or b.parity()
        fun inverseComboIndex(a: Int, b: Int) = (a.inverseParity() shl 1) or b.parity()

        fun solve(a: Char, b: Char): Int {
            var aFreqLeft = 0
            var aFreqTotal = 0
            var bFreqLeft = 0
            var bFreqTotal = 0
            var l = 0
            var ans = Int.MIN_VALUE
            val best = IntArray(4) { Int.MAX_VALUE }

            for (r in 0..<n) {
                if (s[r] == a) aFreqTotal++
                if (s[r] == b) bFreqTotal++

                while (r - l + 1 >= k && aFreqTotal - aFreqLeft > 0 && bFreqTotal - bFreqLeft > 1) {
                    val leftCombo = comboIndex(aFreqLeft, bFreqLeft)
                    best[leftCombo] = min(
                        best[leftCombo],
                        aFreqLeft - bFreqLeft
                    )

                    if (s[l] == a) aFreqLeft++
                    if (s[l] == b) bFreqLeft++
                    l++
                }

                val targetLeftComboIndex = inverseComboIndex(aFreqTotal, bFreqTotal)
                if (best[targetLeftComboIndex] != Int.MAX_VALUE) {
                    ans = max(ans, (aFreqTotal - bFreqTotal) - best[targetLeftComboIndex])
                }
            }

            return ans
        }

        var ans = Int.MIN_VALUE
        for (a in '0'..'4') {
            for (b in '0'..'4') {
                if (a != b) {
                    ans = max(ans, solve(a, b))
                }
            }
        }
        return ans
    }
}