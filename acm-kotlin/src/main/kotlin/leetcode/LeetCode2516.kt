package leetcode

import kotlin.math.min

class LeetCode2516 {
    fun takeCharacters(s: String, k: Int): Int {
        if (k == 0) {
            return 0
        }

        val n = s.length
        var l = 0
        var r = 0
        var minLength = Int.MAX_VALUE
        val count = mutableMapOf<Char, Int>()

        fun getCount(c: Char) = count.getOrDefault(c, 0)
        fun isValid() = getCount('a') >= k && getCount('b') >= k && getCount('c') >= k
        fun decrement(c: Char) {
            if (getCount(c) > 0) {
                count[c] = getCount(c) - 1
            }
        }
        fun increment(c: Char) {
            count[c] = getCount(c) + 1
        }

        while (r < n) {
            increment(s[r])
            r++
            if (isValid()) {
                minLength = min(minLength, r - l)
            }
        }

        while (l < n && r < 2 * n) {
            while (l < n && r - l >= n) {
                decrement(s[l])
                l++
            }

            while (l < n && isValid()) {
                minLength = min(minLength, r - l)
                decrement(s[l])
                l++
            }

            increment(s[r % n])
            r++
        }
        return if (minLength == Int.MAX_VALUE) -1 else minLength
    }
}