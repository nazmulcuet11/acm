package leetcode

import kotlin.math.min

/*
class LeetCode2311 {
    fun longestSubsequence(s: String, k: Int): Int {
        val n = s.length
        val cache = Array(n + 1) { LongArray(n + 1) { -1 } }
        fun getMinNumber(i: Int, l: Int): Long {
            if (l == 0) return 0
            if (i < 0) return k + 1L

            if (cache[i][l] != -1L) return cache[i][l]

            val a = getMinNumber(i - 1, l - 1) * 2 + s[i].digitToInt()
            val b = getMinNumber(i - 1, l)
            cache[i][l] = min(a, b)
            return cache[i][l]
        }

        var left = 0
        var right = n
        while (left < right) {
            val mid = (left + right + 1) / 2
            val minNumber = getMinNumber(s.length - 1, mid)
            if (minNumber <= k) {
                left = mid
            } else {
                right = mid - 1
            }
        }
        return left
    }
}
*/

/*
class LeetCode2311 {
    fun longestSubsequence(s: String, k: Int): Int {
        val n = s.length
        val taken = BooleanArray(n) {  s[it] == '0' }

        fun verify(): Boolean {
            var number = 0L
            for (i in 0..<n) {
                if (taken[i]) {
                    number = number * 2 + s[i].digitToInt()
                }
                if (number > k) {
                    return false
                }
            }
            return true
        }

        var ans = taken.count { it }
        for (i in n - 1 downTo 0) {
            if (s[i] == '1') {
                taken[i] = true
                if (verify()) {
                    ans++
                } else {
                    break
                }
            }
        }

        return ans
    }
}
*/

class LeetCode2311 {
    fun longestSubsequence(s: String, k: Int): Int {
        val n = s.length
        val zeroCount = s.count { it == '0' }
        var mask = 0L
        var ans = zeroCount
        for (i in 0..<min(n, 64)) {
            if (s[n - 1 - i] == '1') {
                mask = mask or (1L shl i)
                if (mask <= k) {
                    ans++
                } else {
                    break
                }
            }
        }

        return ans
    }
}