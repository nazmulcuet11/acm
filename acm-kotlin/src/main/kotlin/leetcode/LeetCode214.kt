package leetcode

class LeetCode214 {
    private fun computeLPS(s: String): List<Int> {
        val lps = MutableList(s.length) { 0 }
        var i = 1
        var j = 0
        while (i < s.length) {
            if (s[i] == s[j]) {
                lps[i] = j + 1
                i++
                j++
            } else {
                if (j == 0) {
                    i++
                } else {
                    j = lps[j - 1]
                }
            }
        }
        return lps
    }

    fun shortestPalindrome(s: String): String {
        val t = s + "*" + s.reversed()
        val lps = computeLPS(t)
        val ans = s.substring(lps[t.length - 1]).reversed() + s
        return ans
    }
}