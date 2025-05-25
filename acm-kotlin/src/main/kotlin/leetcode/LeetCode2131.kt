package leetcode

import kotlin.math.min

class LeetCode2131 {
    fun longestPalindrome(words: Array<String>): Int {
        val count = mutableMapOf<String, Int>()
        for (w in words) {
            count[w] = count.getOrDefault(w, 0) + 1
        }

        val taken = mutableSetOf<String>()
        var ans = 0
        var odd = 0
        for ((k, v) in count) {
            if (taken.contains(k)) {
                continue
            }

            taken.add(k)

            if (k[0] != k[1]) {
                val t = "${k[1]}${k[0]}"
                ans += 4 * min(
                    count.getOrDefault(k, 0),
                    count.getOrDefault(t, 0)
                )
                taken.add(t)
            } else {
                if (v % 2 == 0) {
                    ans += v * 2
                } else {
                    if (odd == 0) {
                        ans += v * 2
                    } else {
                        ans += (v - 1) * 2
                    }
                    odd++
                }
            }
        }

        return ans
    }
}