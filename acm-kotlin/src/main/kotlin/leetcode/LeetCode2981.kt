package leetcode

import kotlin.math.max

/*
class LeetCode2981 {
    private fun isSpecial(s: String): Boolean {
        for (i in 1..<s.length) {
            if (s[i] != s[i - 1]) {
                return false
            }
        }
        return true
    }

    private fun haveSpecialSubstringOfLen(s: String, l: Int): Boolean {
        val map = mutableMapOf<String, Int>()
        for (i in 0..s.length - l) {
            val sub = s.substring(i..<i + l)
            if (isSpecial(sub)) {
                map[sub] = map.getOrDefault(sub, 0) + 1
            }
            if (map.getOrDefault(sub, 0) >= 3) {
                return true
            }
        }
        return false
    }

    fun maximumLength(s: String): Int {
        for (l in s.length - 2 downTo 1) {
            if (haveSpecialSubstringOfLen(s, l)) {
                return l
            }
        }
        return -1
    }
}
*/

/*
class LeetCode2981 {
    fun maximumLength(s: String): Int {
        val m = mutableMapOf<String, Int>()
        for (i in s.indices) {
            var sub = ""
            for (j in i..<s.length) {
                if (s[j] == s[i]) {
                    sub += s[j]
                    m[sub] = m.getOrDefault(sub, 0) + 1
                } else {
                    break
                }
            }
        }
        var ans = -1
        for ((k, v) in m) {
            if (v >= 3) {
                ans = max(ans, k.length)
            }
        }
        return ans
    }
}
*/

class LeetCode2981 {
    fun maximumLength(s: String): Int {
        val m = mutableMapOf<Pair<Char, Int>, Int>()
        for (i in s.indices) {
            var count = 0
            for (j in i..<s.length) {
                if (s[j] == s[i]) {
                    count++
                    val key = Pair(s[i], count)
                    m[key] = m.getOrDefault(key, 0) + 1
                } else {
                    break
                }
            }
        }
        var ans = -1
        for ((k, v) in m) {
            if (v >= 3) {
                ans = max(ans, k.second)
            }
        }
        return ans
    }
}